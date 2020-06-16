package orm.sbblog.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import orm.sbblog.model.Blog;
import orm.sbblog.service.BlogService;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public ModelAndView getHome() {
        return new ModelAndView("index","listBlog",blogService.findAllByStatusIsTrue());
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
        modelAndView.addObject("message","Create New Blog Successfully");
        return modelAndView;
    }
}
