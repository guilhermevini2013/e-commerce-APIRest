package com.example.ecommerce_restapi.dtos;

import com.example.ecommerce_restapi.models.Category;

public class CategoryDTO {
    private long id;
    private String name;
    public CategoryDTO(Category entity){
        this.id=entity.getId();
        this.name=entity.getName();
    }
}
