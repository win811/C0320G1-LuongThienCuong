package controllers.condiment_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CondimentController {
    @GetMapping("/sandwich-condiments")
    public ModelAndView chooseCondiments () {
        return new ModelAndView("condiments/condiments");
    }
    @GetMapping("/condiment-results")
    private ModelAndView condimentResults (@RequestParam(value = "condiment",required = false, defaultValue = "Đéo Chọn" ) String[] condimentResults) {
//        String[] a = {"a","b"};
        return new ModelAndView("condiments/condiment-results","condimentResults",condimentResults);
    }

}
