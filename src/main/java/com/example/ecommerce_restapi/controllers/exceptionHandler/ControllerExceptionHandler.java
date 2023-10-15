package com.example.ecommerce_restapi.controllers.exceptionHandler;

import com.example.ecommerce_restapi.service.exceptions.BodyError;
import com.example.ecommerce_restapi.service.exceptions.EntityNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.Instant;
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<BodyError> entityNotfound(EntityNotFound e, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BodyError(Instant.now(),HttpStatus.NOT_FOUND.value(), "Entity Not found",request.getServletPath()));
    }
}
