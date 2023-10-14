package com.example.ecommerce_restapi.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
@Getter
@AllArgsConstructor
public class BodyError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
}
