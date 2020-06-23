package spring.data.jpa.customer_province.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.data.jpa.customer_province.model.Province;
import spring.data.jpa.customer_province.service.province_service.ProvinceService;

import javax.validation.Valid;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/")
    public ModelAndView getProvinceHome(@RequestParam(name = "searchByName",required = false,defaultValue = "") String searchByName,
                                        @PageableDefault(value = 5) Pageable pageable) {
//        if (searchByName == null) {
//            searchByName = "";
//        }
        searchByName = searchByName.trim();
        ModelAndView modelAndView = new ModelAndView("/province/home-province");
        modelAndView.addObject("pageProvince",provinceService.findAllProvinceByName(searchByName,pageable));
        modelAndView.addObject("searchByName",searchByName);
        return modelAndView;
    }

    @GetMapping("/create-form")
    public ModelAndView createForm() {
        return new ModelAndView("/province/create","province",new Province());
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute Province province, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        province.setStatus(true);
        provinceService.saveProvince(province);
        modelAndView.addObject("province",province);
        modelAndView.addObject("message","Create New Province Successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        return new ModelAndView("province/edit","province",provinceService.findProvinceById(id));
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Province province) {
        province.setStatus(true);
        provinceService.saveProvince(province);
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        modelAndView.addObject("province",province);
        modelAndView.addObject("message","Edit Province Successfully");
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        Province province = provinceService.findProvinceById(id);
        province.setStatus(false);
        provinceService.saveProvince(province);
        return "redirect:/provinces/";
    }
}
