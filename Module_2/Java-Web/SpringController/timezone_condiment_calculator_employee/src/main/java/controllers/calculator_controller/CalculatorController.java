package controllers.calculator_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("/")
    public ModelAndView calculate(@RequestParam(value = "firstNumber",required = false) Float firstNumber,
                                  @RequestParam(value = "secondNumber",required = false) Float secondNumber,
                                  @RequestParam(value = "button",required = false ) String choose) {
        ModelAndView modelAndView;
        Float resultCalculator = null;
        if (firstNumber == null || secondNumber == null) {
            modelAndView = new ModelAndView("calculator/calculator");
        } else {
            switch (choose) {
                case "Addition(+)" :
                    resultCalculator = firstNumber + secondNumber;
                    break;
                case "Subtraction(+)" :
                    resultCalculator = firstNumber - secondNumber;
                    break;
                case "Multiplication(x)" :
                    resultCalculator = firstNumber * secondNumber;
                    break;
                case "Division(/)" :
                    resultCalculator = firstNumber / secondNumber;
                    break;
            }
//            assert resultCalculator != null;
            modelAndView = new ModelAndView("calculator/calculator","resultCalculator",resultCalculator);
            modelAndView.addObject("firstNumber",firstNumber);
            modelAndView.addObject("secondNumber",secondNumber);
        }
        return modelAndView;
    }
}
