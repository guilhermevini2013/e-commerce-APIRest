package com.example.ecommerce_restapi.repositories;

import com.example.ecommerce_restapi.Factory;
import com.example.ecommerce_restapi.models.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository repository;
    private Long idExists;
    private Long idNotExists;
    private Product product;
    private Optional<Product> productOptional;
    private Integer totalIdProduct;
    @BeforeEach
    void setUp(){
        idExists = 1l;
        idNotExists = 1000000l;
        product = Factory.createProduct();
        totalIdProduct = 1;
        productOptional = null;
    }
    @Test
    public void deleteShouldDeleteObjectWhenIdExists(){
        repository.deleteById(idExists);
        Assertions.assertFalse(repository.findById(idExists).isPresent());
    }
    @Test
    public void insertShouldPersistWithAutoIncrementWhenIdIsNull(){
        product.setId(null);
        product = repository.save(product);
        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals(totalIdProduct+1,product.getId());
    }
    @Test
    public void findByIdShouldReturnOptionalNoNullWhenIdExists(){
        productOptional = repository.findById(idExists);
        Assertions.assertFalse(productOptional.isEmpty());
    }
    @Test
    public void findByIdShouldReturnNullOptionalWhenIdNotExists(){
        productOptional = repository.findById(idNotExists);
        Assertions.assertTrue(productOptional.isEmpty());
    }

}
