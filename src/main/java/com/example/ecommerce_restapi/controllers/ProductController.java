package com.example.ecommerce_restapi.controllers;

import com.example.ecommerce_restapi.dtos.ProductDTO;
import com.example.ecommerce_restapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> list(@RequestParam(value = "page", defaultValue = "0") Integer pages,
                                                 @RequestParam(value = "linesPerPage", defaultValue = "15")Integer linesPerPage,
                                                 @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                 @RequestParam(value = "orderBy", defaultValue = "id") String orderBy){
        return ResponseEntity.ok(productService.list(PageRequest.of(pages,linesPerPage, Sort.Direction.valueOf(direction),orderBy)));
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));
    }
}
