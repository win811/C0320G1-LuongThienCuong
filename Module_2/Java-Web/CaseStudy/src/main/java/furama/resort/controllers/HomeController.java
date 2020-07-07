package furama.resort.controllers;

import furama.resort.models.dto.SignUpDto;
import furama.resort.services.SignUpDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    SignUpDtoService signUpDtoService;

    @Autowired
    SignUpDto signUpDtoValidate;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/")
    public String getHome(Principal principal) {
        if (principal != null) {
            if (principal.getName().equals("admin")) {
                return "adminPage";
            }
        }
        return "index2";
    }

    @GetMapping("/admin")
    public String showAdminHome() {
        return "adminPage";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "loginPage";
    }

    @GetMapping("/logout")
    public String logOut(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        return "redirect:/";
    }

    @GetMapping("/403")
    public String accessDenied () {
        return "403Page";
    }

    @GetMapping("/sign-up")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/sign_up/sign-up-form","signUpDto",new SignUpDto());
    }

    @PostMapping("/sign-up")
    public ModelAndView create(@Valid @ModelAttribute SignUpDto signUpDto, BindingResult bindingResult) {
        signUpDtoValidate.validate(signUpDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/sign_up/sign-up-form");
        }
        signUpDtoService.saveCustomerAndAccount(signUpDto);
        return new ModelAndView("/sign_up/sign-up-form","message","Sign Up SuccessFully");
    }
}
