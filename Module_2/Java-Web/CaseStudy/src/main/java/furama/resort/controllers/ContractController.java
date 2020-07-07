package furama.resort.controllers;

import furama.resort.models.AttachService;
import furama.resort.models.Contract;
import furama.resort.models.Customer;
import furama.resort.models.Service;
import furama.resort.models.dto.ContractDto;
import furama.resort.services.AttachServiceService;
import furama.resort.services.ContractService;
import furama.resort.services.CustomerService;
import furama.resort.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class ContractController {
    @Autowired
    ContractService contractService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    AttachServiceService attachServiceService;

    @Autowired
    CustomerService customerService;

    @ModelAttribute("listAttachService")
    public List<AttachService> getAllAttachService () {
        return attachServiceService.getAllAttachService();
    }

    //--------------Admin--------------//

    @GetMapping("/admin/contract/")
    public ModelAndView showAllContract(@PageableDefault(value = 2) Pageable pageable) {

        return new ModelAndView("/contract/page-booking","pageAllContract",contractService.findAllContract(pageable));

    }

    @GetMapping("/admin/contract/on/{id}")
    public String adminSetOn (@PathVariable long id) {
        Contract contract = contractService.findContractById(id);
        contract.setStatus(true);
        contractService.saveContract(contract);
        return "redirect:/admin/contract/";
    }

    @GetMapping("/admin/contract/off/{id}")
    public String adminSetOff (@PathVariable long id) {
        Contract contract = contractService.findContractById(id);
        contract.setStatus(false);
        contractService.saveContract(contract);
        return "redirect:/admin/contract/";
    }

    @GetMapping("/admin/contract/valid")
    public ModelAndView showContractValid (@PageableDefault(value = 2) Pageable pageable) {
        LocalDate localDateNow = LocalDate.now();
        return new ModelAndView("/contract/page-booking","pageAllContract",
                contractService.findAllContractHasEndDateAfterToday(localDateNow,pageable));
    }

    //--------------Customer--------------//

    @GetMapping("/contract/my-booking/")
    public ModelAndView myBooking(@PageableDefault(value = 2) Pageable pageable, Principal principal) {
        Customer customer = customerService.findCustomerByAccount(principal.getName());
        Page<Contract> page = contractService.findContractByCustomerId(customer.getId(),pageable);
        return new ModelAndView("/contract/my-booking","pageMyContract",page);
    }

    @GetMapping("/contract/my-booking/on/{id}")
    public String customerSetOn (@PathVariable long id) {
        Contract contract = contractService.findContractById(id);
        contract.setStatus(true);
        contractService.saveContract(contract);
        return "redirect:/contract/my-booking/";
    }

    @GetMapping("/contract/my-booking/off/{id}")
    public String customerSetOff (@PathVariable long id) {
        Contract contract = contractService.findContractById(id);
        contract.setStatus(false);
        contractService.saveContract(contract);
        return "redirect:/contract/my-booking/";
    }

    @GetMapping("/contract/booking/{id}")
    public ModelAndView showBookingForm(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("/contract/booking-form");
        modelAndView.addObject("service",serviceService.findServiceById(id));
        modelAndView.addObject("contractDto",new ContractDto());
        return modelAndView;
    }

    @PostMapping("/contract/booking/{id}")
    public ModelAndView booking(@PathVariable long id,
                                @Valid @ModelAttribute ContractDto contractDto,
                                BindingResult bindingResult,
                                Principal principal) {
        ModelAndView modelAndView = new ModelAndView("/contract/booking-form");
        if (bindingResult.hasFieldErrors()) {
            return modelAndView;
        }

        Customer customer = customerService.findCustomerByAccount(principal.getName());
        Service service = serviceService.findServiceById(id);
        contractService.saveContract(contractDto,service,customer);
        modelAndView.addObject("service",serviceService.findServiceById(id));
        modelAndView.addObject("message","Booking SuccessFully");
        return modelAndView;
    }




}
