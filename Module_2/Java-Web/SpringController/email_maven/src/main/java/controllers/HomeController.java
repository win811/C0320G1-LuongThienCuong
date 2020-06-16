package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
//    private static Pattern pattern;
//    private Matcher matcher;
    // Khai báo Regex
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

//    public HomeController() {
//        pattern = Pattern.compile(EMAIL_REGEX);
//    }

    @GetMapping("/home")
    public String home(Locale locale, Model model) {
        return "home";
    }

    @PostMapping("/validate")
    public String user(@RequestParam("email") String email, ModelMap model) {
        boolean isValid = this.validate(email);
        if (!isValid) {
            model.addAttribute("message", "Email is invalid");
            return "home";
        }
        model.addAttribute("email", email);
        return "success";
    }

    private boolean validate(String email) {
//        matcher = pattern.matcher(regex);
//        return matcher.matches();
        return email.matches(EMAIL_REGEX);
    }

}
