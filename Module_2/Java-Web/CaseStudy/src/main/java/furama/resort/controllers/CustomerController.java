package furama.resort.controllers;

import furama.resort.models.Customer;
import furama.resort.models.CustomerType;
import furama.resort.models.Service;
import furama.resort.services.CustomerService;
import furama.resort.services.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @ModelAttribute("listCustomerType")
    public List<CustomerType> getListCustomerType () {
        return customerTypeService.getAllCustomerType();
    }

    //--------------Admin--------------//

    @GetMapping("/admin/customer/")
    public ModelAndView showAllCustomer(@RequestParam(name = "searchByName",defaultValue = "") String searchByName,
                                        @RequestParam(name = "searchByCode",defaultValue = "") String searchByCode,
                                        @PageableDefault(value = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/customer/page-customer");
        modelAndView.addObject("pageCustomer",customerService.findCustomerByNameAndCode(searchByName,searchByCode,pageable));
        modelAndView.addObject("searchByName",searchByName);
        modelAndView.addObject("searchByCode",searchByCode);
        return modelAndView;
    }

    @GetMapping("/admin/customer/edit/{id}")
    public ModelAndView showCustomerEditForm(@PathVariable long id) {
        return new ModelAndView("/customer/edit-form","customer",customerService.findCustomerById(id));
    }

    @PostMapping("/admin/customer/edit")
    public ModelAndView customerEdit(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/customer/edit-form");
        }
        customer.setStatus(true);
        customerService.saveCustomer(customer);
        return new ModelAndView("/customer/edit-form","message","Edit SuccessFully");
    }

    @GetMapping("/admin/customer/on/{id}")
    public String setCustomerOn (@PathVariable long id) {
        Customer customer = customerService.findCustomerById(id);
        customer.getAccount().setStatus(true);
        customer.setStatus(true);
        customerService.saveCustomer(customer);
        return "redirect:/admin/customer/";
    }

    @GetMapping("/admin/customer/off/{id}")
    public String setCustomerOff (@PathVariable long id) {
        Customer customer = customerService.findCustomerById(id);
        customer.getAccount().setStatus(false);
        customer.setStatus(false);
        customerService.saveCustomer(customer);
        return "redirect:/admin/customer/";
    }

    //--------------Customer--------------//

    @GetMapping("/customer/update/")
    public ModelAndView showUpdateForm (Principal principal) {
        Customer customer  =customerService.findCustomerByAccount(principal.getName());
        return new ModelAndView("customer/update-form","customer",customer);
    }

    @PostMapping("/customer/update/")
    public ModelAndView update (@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
        customer.validate(customer,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("customer/update-form");
        }
        customer.setStatus(true);
        customerService.saveCustomer(customer);
        return new ModelAndView("customer/update-form","message","Update SuccessFully");
    }


}
