package com.example.ecommerce_restapi.service.interfaceService;

import java.util.List;

public interface Iservice<T> {
    T insert(T t);
    T findById(Long l);
    void deleteById(Long l);
    T alter(Long l,T t);
    List<T> list();
}
