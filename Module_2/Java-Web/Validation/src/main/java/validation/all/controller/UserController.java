package validation.all.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import validation.all.model.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/")
    public ModelAndView getHome() {
        return new ModelAndView("/user/index","user",new User());
    }

    @PostMapping("/")
    public ModelAndView validate(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/user/index");
        if (bindingResult.hasFieldErrors()) {
            return modelAndView;
        }
        modelAndView.addObject("message","Successfully");
        return modelAndView;
    }
}
