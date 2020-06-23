package orm.sbblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import orm.sbblog.model.Blog;
import orm.sbblog.model.MyCounter;
import orm.sbblog.service.BlogService;

@Controller
@SessionAttributes("myCounter")
public class BlogController {

    @ModelAttribute("myCounter")
    public MyCounter setUpCounter() {
        return new MyCounter();
    }

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public ModelAndView getHome(@RequestParam(name = "searchByName", defaultValue = "") String searchByName,
                                @RequestParam(name = "searchByContent", defaultValue = "") String searchByContent,
                                @PageableDefault(value = 5) Pageable pageable,
                                @ModelAttribute MyCounter myCounter) {

        myCounter.increment();
//        if (searchByName == null && searchByContent == null) {
//            searchByName = "";
//            searchByContent = "";
//        }
        searchByName = searchByName.trim();
        searchByContent = searchByContent.trim();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("listBlog", blogService.findAllBlogByNameContainingAndContentContaining(searchByName,searchByContent,pageable));
        modelAndView.addObject("searchByName",searchByName);
        modelAndView.addObject("searchByContent",searchByContent);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewBlog(@PathVariable Integer id) {
        return new ModelAndView("view","blog",blogService.findBlogById(id));
    }

    @GetMapping("/create-form")
    public ModelAndView createForm() {
        return new ModelAndView("create","blog",new Blog());
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Blog blog) {
        blog.setStatus(true);
        blogService.saveBlog(blog);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog",blog);
        modelAndView.addObject("message","Create New Blog Successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editFrom(@PathVariable Integer id) {
        return new ModelAndView("edit","blog",blogService.findBlogById(id));
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Blog blog) {
        blog.setStatus(true);
        blogService.saveBlog(blog);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog",blog);
        modelAndView.addObject("message","Edit Blog Successfully");
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        Blog blog = blogService.findBlogById(id);
        blog.setStatus(false);
        blogService.saveBlog(blog);
        return "redirect:/";
    }
}
