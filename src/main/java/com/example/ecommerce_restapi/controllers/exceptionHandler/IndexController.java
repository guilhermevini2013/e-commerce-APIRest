package com.example.ecommerce_restapi.controllers.exceptionHandler;

import com.example.ecommerce_restapi.service.CategoryService;
import com.example.ecommerce_restapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Autowired
    private ProductService productService;
    @GetMapping("/index")
    public String showIndex(Model model){
        model.addAttribute("listProduct",productService.list());
        return "index";
    }
    @PostMapping("/index")
    public String searchProductByName(@RequestParam(name = "productName")String productName,Model model){
        model.addAttribute("listProduct",productService.listFilter(productName,productName));
        return "index";
    }
}
