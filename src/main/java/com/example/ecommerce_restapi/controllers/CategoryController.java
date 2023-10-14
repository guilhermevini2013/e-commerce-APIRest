package com.example.ecommerce_restapi.controllers;

import com.example.ecommerce_restapi.dtos.CategoryDTO;
import com.example.ecommerce_restapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService service;
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> list(){
        return ResponseEntity.ok().body(service.list());
    }
    @PostMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
}
