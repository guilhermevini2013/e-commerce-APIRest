package com.example.ecommerce_restapi.service.exceptions;

public class DataBaseException extends RuntimeException{
    public DataBaseException(String message) {
        super(message);
    }
}
