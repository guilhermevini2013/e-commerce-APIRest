package com.example.ecommerce_restapi;

import com.example.ecommerce_restapi.dtos.ProductDTO;
import com.example.ecommerce_restapi.models.Category;
import com.example.ecommerce_restapi.models.Product;

public class Factory {
    public static Product createProduct(){
        Product product = new Product(null,"Carrinho","muito bom",100.0,"www.www");
        product.getCategories().add(new Category(1l,"Brinquedos"));
        return product;
    }
    public static ProductDTO createProductDTO(){
        Product entity = createProduct();
        return new ProductDTO(entity,entity.getCategories());
    }
}
