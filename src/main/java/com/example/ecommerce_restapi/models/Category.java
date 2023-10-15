package com.example.ecommerce_restapi.models;

import com.example.ecommerce_restapi.dtos.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

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

    public Category(CategoryDTO categoryDTO) {
        this.id= categoryDTO.getId();
        this.name= categoryDTO.getName();
    }
}
