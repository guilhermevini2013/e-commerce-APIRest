package com.example.ecommerce_restapi.dtos;

import com.example.ecommerce_restapi.models.Category;
import com.example.ecommerce_restapi.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    private Set<CategoryDTO> categories = new HashSet<>();

    public ProductDTO(Product entity) {
        this.id=entity.getId();
        this.name= entity.getName();
        this.description=entity.getDescription();
        this.price=entity.getPrice();
        this.imgUrl=entity.getImg_url();
    }
    public ProductDTO(Product entity,Set<Category> categories){
        this(entity);
        categories.forEach(x-> this.categories.add(new CategoryDTO(x)));
    }
}
