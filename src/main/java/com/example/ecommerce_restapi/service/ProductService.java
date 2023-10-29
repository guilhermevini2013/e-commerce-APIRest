package com.example.ecommerce_restapi.service;

import com.example.ecommerce_restapi.dtos.CategoryDTO;
import com.example.ecommerce_restapi.dtos.ProductDTO;
import com.example.ecommerce_restapi.models.Category;
import com.example.ecommerce_restapi.models.Product;
import com.example.ecommerce_restapi.repositories.CategoryRepository;
import com.example.ecommerce_restapi.repositories.ProductRepository;
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

import java.util.Optional;

@Service
public class ProductService implements Iservice<ProductDTO> {
    @Autowired
    private ProductRepository productRepository ;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    @Transactional(readOnly = true)
    public ProductDTO findById(Long l) {
        Optional<Product> product = Optional.ofNullable(productRepository.findById(l).orElseThrow(() -> new ResourceNotFoundException("id not found " + l)));
        return new ProductDTO(product.get(),product.get().getCategories());
    }
    @Override
    @Transactional(readOnly = true)
    public Page<ProductDTO> list(PageRequest pr) {
        return productRepository.findAll(pr).map(x-> new ProductDTO(x,x.getCategories()));
    }

    @Override
    public void deleteById(Long id) {
        try{
            Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id not Found "+id));
            productRepository.delete(product);
        }catch (DataIntegrityViolationException ex){
            throw new DataBaseException("Integrity Violation");
        }
    }
    @Override
    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        Product entity = new Product();
        copyDTOtoEntity(productDTO,entity);
        entity = productRepository.save(entity);
        return new ProductDTO(entity,entity.getCategories());
    }
    @Override
    @Transactional
    public ProductDTO alter(Long id, ProductDTO productDTO) {
        try{
            Product entity = productRepository.getReferenceById(id);
            copyDTOtoEntity(productDTO,entity);
            entity = productRepository.save(entity);
            return new ProductDTO(entity,entity.getCategories());
        }catch (EntityNotFoundException ex){
            throw new ResourceNotFoundException("Id not found "+id);
        }
    }
    private void copyDTOtoEntity(ProductDTO dto, Product entity){
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        entity.setImg_url(dto.getImgUrl());
        for (CategoryDTO category: dto.getCategories()) {
            Category c = categoryRepository.getReferenceById(category.getId());
            entity.getCategories().add(c);
        }
    }
}
