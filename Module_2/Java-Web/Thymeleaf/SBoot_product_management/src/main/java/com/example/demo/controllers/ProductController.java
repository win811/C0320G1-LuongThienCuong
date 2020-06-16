package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ModelAndView products() {
        return new ModelAndView("products","listProduct",productService.getAllProduct());
    }

    @GetMapping("/create-form")
    public ModelAndView showCreate() {
        return new ModelAndView("create","product",new Product());
    }

    @PostMapping("/created")
    public ModelAndView created(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        product.setId( (int) (Math.random() * 10000) );
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("success","Create Product Successfully");
        return new ModelAndView("redirect:/products/");
    }

    @GetMapping("/edit-form/{id}")
    public ModelAndView showEdit(@PathVariable Integer id) {
        return new ModelAndView("edit","product",productService.getProductById(id));
    }

    @PostMapping("/edited")
    public ModelAndView edited(@ModelAttribute Product product,RedirectAttributes redirectAttributes) {
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("success","Edit Product Successfully");
        return new ModelAndView("redirect:/products/");
    }

    @GetMapping("/delete-form/{id}")
    public ModelAndView showDelete(@PathVariable Integer id) {
        return new ModelAndView("delete","product",productService.getProductById(id));
    }

    @PostMapping("/deleted")
    public ModelAndView deleted(@ModelAttribute Product product,RedirectAttributes redirectAttributes) {
        productService.deleteProductById(product.getId());
        redirectAttributes.addFlashAttribute("success","Delete Product Successfully");
        return new ModelAndView("redirect:/products/");
    }

    @GetMapping("/view-form/{id}")
    public ModelAndView showView(@PathVariable Integer id) {
        return new ModelAndView("view","product",productService.getProductById(id));
    }


}
