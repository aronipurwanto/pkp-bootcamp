package com.bootcamp.belajarapi.service;

import com.bootcamp.belajarapi.entity.ProductEntity;
import com.bootcamp.belajarapi.model.ProductModel;
import com.bootcamp.belajarapi.model.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductResponse> getAll();
    Optional<ProductResponse> getById(int id);
    Optional<ProductResponse> save(ProductModel request);
    Optional<ProductResponse> update(ProductModel request, int id);
    Optional<ProductResponse> delete(int id);
}
