package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/currency-converter")
    public String viewConverter() {
        return "/WEB-INF/index.jsp";
    }
    @PostMapping("/currency-converter")
    public String convert(@RequestParam("rate") float rate, @RequestParam("usd") float usd ,Model model) {
        float vnd = usd*rate;
        model.addAttribute("rate",rate);
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",vnd);
        return "result";
    }
}
