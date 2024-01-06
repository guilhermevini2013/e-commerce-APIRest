package com.example.ecommerce_restapi.service;

import com.example.ecommerce_restapi.dtos.CategoryDTO;
import com.example.ecommerce_restapi.models.Category;
import com.example.ecommerce_restapi.repositories.CategoryRepository;
import com.example.ecommerce_restapi.service.exceptions.DataBaseException;
import com.example.ecommerce_restapi.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO categoryDTO) {
        Category entity = new Category(categoryDTO);
        categoryRepository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO findById(Long l) {
        return new CategoryDTO(categoryRepository.findById(l).orElseThrow(() -> new ResourceNotFoundException("Entity not found")));
    }


    public void deleteById(Long id) {
        try {
            Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            categoryRepository.delete(category);
        } catch (DataIntegrityViolationException ex) {
            throw new DataBaseException("Integrity Violation");
        }
    }

    @Transactional
    public CategoryDTO alter(Long id, CategoryDTO categoryDTO) {
        try {
            Category entity = categoryRepository.getReferenceById(id);
            entity.setName(categoryDTO.getName());
            categoryRepository.save(entity);
            return new CategoryDTO(entity);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> list() {
        return categoryRepository.findAll().stream().map(x -> new CategoryDTO(x)).toList();
    }

}
