package com.example.ecommerce_restapi.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

@DataJpaTest
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository repository;
    private Long idExists;
    private Long idNotExists;
    @BeforeEach
    void setUp() throws Exception{
        idExists = 1l;
        idNotExists = 1000000l;
    }
    @Test
    public void deleteShouldDeleteObjectWhenIdExists(){
        repository.deleteById(idExists);
        Assertions.assertFalse(repository.findById(idExists).isPresent());
    }

}
