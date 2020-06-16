package controllers.employee_management.controllers;

import controllers.employee_management.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @GetMapping("/create_form")
    public ModelAndView createForm() {
        return new ModelAndView("employee/create-form","employee",new Employee());
    }
    @PostMapping("/show_info")
    public ModelAndView showInfo (@ModelAttribute("employee") Employee employee) {
        return new ModelAndView("employee/show-info","employee",employee);
    }

}
