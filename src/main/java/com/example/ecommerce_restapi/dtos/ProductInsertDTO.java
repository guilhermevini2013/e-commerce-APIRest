package com.example.ecommerce_restapi.dtos;

import java.util.HashSet;
import java.util.Set;

public record ProductInsertDTO(String name,String description, Double price, String imgUrl, Set<Long>categories) {
}
