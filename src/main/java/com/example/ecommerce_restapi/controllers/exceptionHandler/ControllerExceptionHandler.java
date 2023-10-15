package com.example.ecommerce_restapi.controllers.exceptionHandler;

import com.example.ecommerce_restapi.service.exceptions.BodyError;
import com.example.ecommerce_restapi.service.exceptions.DataBaseException;
import com.example.ecommerce_restapi.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.Instant;
@ControllerAdvice
public class ControllerExceptionHandler {
    private HttpStatus status;
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<BodyError> entityNotfound(ResourceNotFoundException e, HttpServletRequest request){
        status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BodyError(Instant.now(),status.value(), e.getMessage(),request.getServletPath()));
    }
    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<BodyError> dataBase(DataBaseException e, HttpServletRequest request){
        status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BodyError(Instant.now(),status.value(), e.getMessage(), request.getServletPath()));
    }
}
