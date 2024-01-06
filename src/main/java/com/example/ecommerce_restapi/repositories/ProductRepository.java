package com.example.ecommerce_restapi.repositories;

import com.example.ecommerce_restapi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT DISTINCT p FROM Product p LEFT JOIN p.categories c WHERE p.name LIKE %:name% OR c.name LIKE %:categoryName%")
    List<Product> findProductByFilter(@Param("name") String name, @Param("categoryName") String categoryName);
}
