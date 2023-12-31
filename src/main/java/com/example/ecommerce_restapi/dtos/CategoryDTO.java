package com.example.ecommerce_restapi.dtos;

import com.example.ecommerce_restapi.models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
    public CategoryDTO(Category entity) {
        this.id=entity.getId();
        this.name=entity.getName();
    }
}
