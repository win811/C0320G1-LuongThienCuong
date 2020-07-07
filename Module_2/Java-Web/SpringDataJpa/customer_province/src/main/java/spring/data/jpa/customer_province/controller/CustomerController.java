package spring.data.jpa.customer_province.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.data.jpa.customer_province.model.Customer;
import spring.data.jpa.customer_province.model.Province;
import spring.data.jpa.customer_province.service.customer_service.CustomerService;
import spring.data.jpa.customer_province.service.province_service.ProvinceService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public List<Province> provinces(){
        return provinceService.findAllProvince();
    }

    @GetMapping("/")
    public ModelAndView getCustomerHome(@RequestParam(name = "searchByProvinceName",defaultValue = "") String searchByProvinceName,
                                        @RequestParam(name = "searchByName",defaultValue = "") String searchByName,
                                        @PageableDefault(value = 5) Pageable pageable) {

        searchByName = searchByName.trim();
        ModelAndView modelAndView = new ModelAndView("customer/home-customer");
        modelAndView.addObject("pageCustomer",customerService.findAllCustomerByProvinceNameAndByName(searchByProvinceName,searchByName,searchByName,pageable));
        modelAndView.addObject("searchByName",searchByName);
        modelAndView.addObject("searchByProvinceName",searchByProvinceName);
        return modelAndView;
    }

    @GetMapping("/create-form")
    public ModelAndView createForm() {
        return new ModelAndView("/customer/create","customer",new Customer());
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute Customer customer,BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
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
        return new ModelAndView("customer/edit","customer",customerService.findCustomerById(id));
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Customer customer) {
        customer.setStatus(true);
        customerService.saveCustomer(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        // Không gửi cũng tự qua
        modelAndView.addObject("customer",customer);
        modelAndView.addObject("message","Edit Customer Successfully");
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id,
                         @RequestParam(name = "searchByProvinceName", defaultValue = "") String searchByProvinceName,
                         @RequestParam(name = "searchByName",defaultValue = "") String searchByName,
                         @RequestParam(name = "page",defaultValue = "1") int page) {
        Customer customer = customerService.findCustomerById(id);
        customer.setStatus(false);
        customerService.saveCustomer(customer);
        String urlExtend = "?page=" + page + "&searchByName=" + searchByName + "&searchByProvinceName=" + searchByProvinceName;
        return "redirect:/customers/" + urlExtend;
    }
}
