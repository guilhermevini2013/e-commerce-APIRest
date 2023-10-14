package com.example.ecommerce_restapi.service.exceptions;

public class EntityNotFound extends RuntimeException{
    public EntityNotFound(String message) {
        super(message);
    }
}
