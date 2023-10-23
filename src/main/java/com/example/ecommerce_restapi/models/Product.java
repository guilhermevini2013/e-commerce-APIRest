package com.example.ecommerce_restapi.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;
    @Column(columnDefinition = "TEXT")
    private String imgUrl;
    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns= @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Product(Long id, String name, String description, Double price, String urlImg) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = urlImg;
    }
}
