package com.exam.md2.controllers;

import com.exam.md2.models.Customer;
import com.exam.md2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ModelAndView getCustomerPage(@RequestParam(name = "searchByName",defaultValue = "") String searchByName,
                                        @RequestParam(name = "searchByCode",defaultValue = "") String searchByCode,
                                        @PageableDefault(value = 5)Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("pageCustomer",customerService.findAllByNameAndCode(searchByName,searchByCode,pageable));
        modelAndView.addObject("searchByName",searchByName);
        modelAndView.addObject("searchByCode",searchByCode);
        return modelAndView;

    }

    @GetMapping("/create-form")
    public ModelAndView createForm() {
        return new ModelAndView("create","customer",new Customer());
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
        new Customer().validate(customer,bindingResult);
        ModelAndView modelAndView = new ModelAndView("create");
        if (bindingResult.hasFieldErrors()) {
            return modelAndView;
        }
        customer.setStatus(true);
        customerService.saveCustomer(customer);
//        modelAndView.addObject("customer",customer);
        modelAndView.addObject("message","Create New Customer Successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        return new ModelAndView("edit","customer",customerService.findCustomerById(id));
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Valid @ModelAttribute Customer customer,BindingResult bindingResult) {
        new Customer().validate(customer,bindingResult);
        ModelAndView modelAndView = new ModelAndView("edit");
        if (bindingResult.hasFieldErrors()) {
            return modelAndView;
         }
        customer.setStatus(true);
        customerService.saveCustomer(customer);
        // Không gửi cũng tự qua
        modelAndView.addObject("customer",customer);
        modelAndView.addObject("message","Edit Customer Successfully");
        return modelAndView;
    }

    @GetMapping("/on/{id}")
    public String setCustomerOn (@PathVariable long id,
                                 @RequestParam(name = "searchByCode", defaultValue = "") String searchByCode,
                                 @RequestParam(name = "searchByName",defaultValue = "") String searchByName,
                                 @RequestParam(name = "page",defaultValue = "1") int page) {
        Customer customer = customerService.findCustomerById(id);
        customer.setStatus(true);
        customerService.saveCustomer(customer);
        String urlExtend = "?page=" + page + "&searchByName=" + searchByName + "&searchByCode=" + searchByCode;
        return "redirect:/customers/" + urlExtend;
    }

    @GetMapping("/off/{id}")
    public String setCustomerOff (@PathVariable long id,
                                  @RequestParam(name = "searchByCode", defaultValue = "") String searchByCode,
                                  @RequestParam(name = "searchByName",defaultValue = "") String searchByName,
                                  @RequestParam(name = "page",defaultValue = "1") int page) {
        Customer customer = customerService.findCustomerById(id);
        customer.setStatus(false);
        customerService.saveCustomer(customer);
        String urlExtend = "?page=" + page + "&searchByName=" + searchByName + "&searchByCode=" + searchByCode;
        return "redirect:/customers/" + urlExtend;
    }

}
