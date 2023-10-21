package com.example.ecommerce_restapi.service;

import com.example.ecommerce_restapi.dtos.CategoryDTO;
import com.example.ecommerce_restapi.models.Category;
import com.example.ecommerce_restapi.repositories.CategoryRepository;
import com.example.ecommerce_restapi.service.exceptions.DataBaseException;
import com.example.ecommerce_restapi.service.exceptions.ResourceNotFoundException;
import com.example.ecommerce_restapi.service.interfaces.Iservice;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService implements Iservice<CategoryDTO> {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    @Transactional
    public CategoryDTO insert(CategoryDTO categoryDTO) {
        Category entity = new Category(categoryDTO);
        categoryRepository.save(entity);
        return new CategoryDTO(entity);
    }

    @Override
    @Transactional
    public CategoryDTO findById(Long l) {
        return new CategoryDTO(categoryRepository.findById(l).orElseThrow(()-> new ResourceNotFoundException("Entity not found")));
    }

    @Override
    public void deleteById(Long id) {
        try{
            categoryRepository.deleteById(id);
        }catch (EmptyResultDataAccessException ex){
            throw new ResourceNotFoundException("Id not found "+id);
        }catch (DataIntegrityViolationException ex){
            throw new DataBaseException("Integrity Violation");
        }
    }
    @Override
    @Transactional
    public CategoryDTO alter(Long id, CategoryDTO categoryDTO) {
        try{
            Category entity = categoryRepository.getReferenceById(id);
            entity.setName(categoryDTO.getName());
            categoryRepository.save(entity);
            return new CategoryDTO(entity);
        }catch (EntityNotFoundException ex){
            throw new ResourceNotFoundException("Id not found "+id);
        }
    }
    @Override
    @Transactional(readOnly = true)
    public Page<CategoryDTO> list(PageRequest pageRequest) {
      return categoryRepository.findAll(pageRequest).map(x-> new CategoryDTO(x));
    }

}
