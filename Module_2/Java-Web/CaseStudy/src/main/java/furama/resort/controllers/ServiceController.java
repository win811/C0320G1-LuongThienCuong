package furama.resort.controllers;

import furama.resort.models.Customer;
import furama.resort.models.Service;
import furama.resort.models.ServiceType;
import furama.resort.repositories.ServiceRepository;
import furama.resort.services.ServiceService;
import furama.resort.services.ServiceTypeService;
import furama.resort.services.impl.ServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ServiceController {
    @Autowired
    ServiceService serviceService;

    @Autowired
    ServiceTypeService serviceTypeService;

    @ModelAttribute("listServiceType")
    public List<ServiceType> getListServiceType() {
        return serviceTypeService.getAllServiceType();
    }

    @GetMapping("/admin/service/")
    public ModelAndView showAllService(@PageableDefault(value = 2) Pageable pageable,
                                       @RequestParam(name = "searchByName",defaultValue = "") String searchByName,
                                       @RequestParam(name = "searchByType",defaultValue = "") String searchByType) {
        ModelAndView modelAndView = new ModelAndView("/service/page-service");
        modelAndView.addObject("pageService",serviceService.findServiceByNameAndType(searchByName.trim(),searchByType,pageable));
        modelAndView.addObject("searchByName",searchByName);
        modelAndView.addObject("searchByType",searchByType);
        return modelAndView;
    }

    @GetMapping("/admin/service/create-form")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/service/create-form","service",new Service());
    }

    @PostMapping("/admin/service/create-form")
    public ModelAndView create(@Valid @ModelAttribute Service service, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/service/create-form");
        }
        service.setStatus(true);
        serviceService.saveService(service);
        return new ModelAndView("/service/create-form","message","Create SuccessFully");
    }

    @GetMapping("/admin/service/edit/{id}")
    public ModelAndView showEditForm(@PathVariable long id) {
        return new ModelAndView("/service/edit-form","service",serviceService.findServiceById(id));
    }

    @PostMapping("/admin/service/edit")
    public ModelAndView edit(@Valid @ModelAttribute Service service, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/service/edit-form");
        }
        service.setStatus(true);
        serviceService.saveService(service);
        return new ModelAndView("/service/edit-form","message","Edit SuccessFully");
    }

    @GetMapping("/admin/service/on/{id}")
    public String setOn (@PathVariable long id) {
        Service service = serviceService.findServiceById(id);
        service.setStatus(true);
        serviceService.saveService(service);
        return "redirect:/admin/service/";
    }

    @GetMapping("/admin/service/off/{id}")
    public String setOff (@PathVariable long id) {
        Service service = serviceService.findServiceById(id);
        service.setStatus(false);
        serviceService.saveService(service);
        return "redirect:/admin/service/";
    }

    //------------Customer------------//
    @GetMapping("/service")
    public ModelAndView viewService(@PageableDefault(value = 5) Pageable pageable,
                                       @RequestParam(name = "searchByName",defaultValue = "") String searchByName,
                                       @RequestParam(name = "searchByType",defaultValue = "") String searchByType) {
        ModelAndView modelAndView = new ModelAndView("/service/view-service");
        modelAndView.addObject("pageService",serviceService.findServiceByNameAndTypeAndStatusIsTrue(searchByName,searchByType,pageable));
        modelAndView.addObject("searchByName",searchByName);
        modelAndView.addObject("searchByType",searchByType);
        return modelAndView;
    }
}
