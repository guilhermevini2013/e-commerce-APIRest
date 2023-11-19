package com.example.ecommerce_restapi.models;

import com.example.ecommerce_restapi.dtos.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonAutoDetect
@EqualsAndHashCode
@Setter
@Entity
@Table(name = "categories")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public Category(CategoryDTO categoryDTO) {
        this.id= categoryDTO.getId();
        this.name= categoryDTO.getName();
    }
}
