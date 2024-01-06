package com.example.ecommerce_restapi.service;

import com.example.ecommerce_restapi.dtos.CategoryDTO;
import com.example.ecommerce_restapi.dtos.ProductDTO;
import com.example.ecommerce_restapi.dtos.ProductInsertDTO;
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

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService  {
    @Autowired
    private ProductRepository productRepository ;
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long l) {
        Optional<Product> product = Optional.ofNullable(productRepository.findById(l).orElseThrow(() -> new ResourceNotFoundException("id not found " + l)));
        return new ProductDTO(product.get(),product.get().getCategories());
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> list() {
        return productRepository.findAll().stream().map(x-> new ProductDTO(x,x.getCategories())).toList();
    }


    public void deleteById(Long id) {
        try{
            Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id not Found "+id));
            removecategori(product);
            productRepository.deleteById(product.getId());
        }catch (DataIntegrityViolationException ex){
            throw new DataBaseException("Integrity Violation");
        }
    }
    private void removecategori(Product product){
        product.setCategories(new HashSet<>());
        productRepository.save(product);
    }
    @Transactional(readOnly = true)
    public List<ProductDTO> listFilter(String name, String category){
        return productRepository.findProductByFilter(name,category).stream().map(x-> new ProductDTO(x,x.getCategories())).toList();
    }

    @Transactional
    public ProductDTO insert(ProductInsertDTO productDTO) {
        Product entity = new Product();
        copyDTOtoEntity(productDTO,entity);
        entity = productRepository.save(entity);
        return new ProductDTO(entity,entity.getCategories());
    }

//    @Transactional
//    public ProductDTO alter(Long id, ProductDTO productDTO) {
//        try{
//            Product entity = productRepository.getReferenceById(id);
//            copyDTOtoEntity(productDTO,entity);
//            entity = productRepository.save(entity);
//            return new ProductDTO(entity,entity.getCategories());
//        }catch (EntityNotFoundException ex){
//            throw new ResourceNotFoundException("Id not found "+id);
//        }
//    }
    private void copyDTOtoEntity(ProductInsertDTO dto, Product entity){
        entity.setName(dto.name());
        entity.setPrice(dto.price());
        entity.setDescription(dto.description());
        entity.setImg_url(dto.imgUrl());
        for (Long category: dto.categories()) {
            Category c = categoryRepository.getReferenceById(category);
            entity.getCategories().add(c);
        }
    }
}
