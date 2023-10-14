package com.example.ecommerce_restapi.service;

import com.example.ecommerce_restapi.dtos.CategoryDTO;
import com.example.ecommerce_restapi.models.Category;
import com.example.ecommerce_restapi.repositories.CategoryRepository;
import com.example.ecommerce_restapi.service.interfaceService.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements Iservice<CategoryDTO> {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public CategoryDTO insert(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public CategoryDTO findById(Long l) {
        return null;
    }

    @Override
    public void deleteById(Long l) {

    }

    @Override
    public CategoryDTO alter(Long l, CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> list() {
      return categoryRepository.findAll().stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
    }
}
