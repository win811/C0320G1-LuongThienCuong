package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DictionaryService;
import service.impl.DictionaryServiceImpl;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    DictionaryService dictionaryService = new DictionaryServiceImpl();

    @GetMapping("/dictionary")
    public String viewDictionary() {
        return "index";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam("word") String word, Model model){
        String result = dictionaryService.findByWord(word);
        String translateResult;
        if (result != null) {
            translateResult = result;
        } else {
            translateResult = "Not Found";
        }
        model.addAttribute("translateResult",translateResult);
        model.addAttribute("word",word);
        return "result";
    }
}
