package validation.all.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import validation.all.model.PhoneNumber;


@Controller
@RequestMapping("/phone-number")
public class PhoneController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "/phone_number/index";
    }
    @PostMapping("/")
        public String checkValidation ( @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, Errors errors, Model model){
        new PhoneNumber().validate(phoneNumber, errors);
        if (errors.hasFieldErrors()){
            return "/phone_number/index";
        } else {
//            model.addAttribute("phoneNumber", phoneNumber.getNumber());
            return "/phone_number/result";
        }
    }
}
