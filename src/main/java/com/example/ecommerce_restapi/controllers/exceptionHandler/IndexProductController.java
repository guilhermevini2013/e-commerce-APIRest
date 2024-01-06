package com.example.ecommerce_restapi.controllers.exceptionHandler;

import com.example.ecommerce_restapi.dtos.CategoryDTO;
import com.example.ecommerce_restapi.dtos.ProductDTO;
import com.example.ecommerce_restapi.dtos.ProductInsertDTO;
import com.example.ecommerce_restapi.service.CategoryService;
import com.example.ecommerce_restapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/product")
    public String showIndexProduct(Model model){
        model.addAttribute("listCategory", categoryService.list());
        model.addAttribute("product",new ProductDTO());
        return "createProduct";
    }
    @PostMapping("/product")
    public String createProduct(@ModelAttribute("product") ProductInsertDTO productDTO) {
        productService.insert(productDTO);
        return "redirect:/product";
    }
    @GetMapping("/category")
    public String showIndexcategory(Model model){
        model.addAttribute("category",new CategoryDTO());
        return "createCategory";
    }
    @PostMapping("/category")
    public String createCategory(@ModelAttribute("category") CategoryDTO categoryDTO) {
        categoryService.insert(categoryDTO);
        return "redirect:/category";
    }
    @PostMapping("/remover")
    public String incluirToDo(@RequestParam(name = "idContent") Long id){
        productService.deleteById(id);
        return "redirect:/index";
    }
}
