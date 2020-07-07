package com.example.cart.controllers;

import com.example.cart.models.Cart;
import com.example.cart.models.Product;
import com.example.cart.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping("")
    public ModelAndView goListForm() {
        return new ModelAndView("list", "products", productService.findAllProduct());
    }

    @GetMapping("/view/{id}")
    public ModelAndView goViewForm(@PathVariable("id") Long id) {
        return new ModelAndView("view", "product", productService.findProductById(id));
    }

    @PostMapping("/buy")
    public String addProductToCart(@RequestParam("id") Long id, @RequestParam("quantity") Integer quantity,
                                   @ModelAttribute("cart") Cart cart, RedirectAttributes redirectAttributes) {
        Product product = productService.findProductById(id);
        cart.addProductToCart(product, quantity);
        redirectAttributes.addFlashAttribute("message", "Add product to cart completed!!!");
        return "redirect:/products/";
    }

    @GetMapping("/viewcart")
    public ModelAndView goCartFrom(@ModelAttribute("cart") Cart cart) {
        return new ModelAndView("cart","cartList",cart.getCarList());
    }

    @GetMapping("/deletecart/{id}")
    public String deleteProductFromCart(@PathVariable("id") Long id, @ModelAttribute("cart") Cart cart,
                                        RedirectAttributes redirectAttributes) {
        Product product = productService.findProductById(id);
        cart.removeProductFromCart(product);
        redirectAttributes.addFlashAttribute("message", "Delete product from cart completed!!");
        return "redirect:/products/viewcart";
    }
}

