package com.example.ecommerce_restapi.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface Iservice<T,S> {
    T insert(S t);
    T findById(Long l);
    void deleteById(Long l);
    T alter(Long l,T t);
    Page<T> list(PageRequest pr);
}
