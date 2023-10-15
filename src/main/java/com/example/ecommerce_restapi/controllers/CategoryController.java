package com.example.ecommerce_restapi.controllers;
import com.example.ecommerce_restapi.dtos.CategoryDTO;
import com.example.ecommerce_restapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto){
        CategoryDTO entity = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity).toUri();
        return ResponseEntity.created(uri).body(entity);
    }
}
