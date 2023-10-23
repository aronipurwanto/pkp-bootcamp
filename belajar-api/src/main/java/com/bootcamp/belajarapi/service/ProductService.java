package com.bootcamp.belajarapi.service;

import com.bootcamp.belajarapi.entity.ProductEntity;
import com.bootcamp.belajarapi.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductEntity> getAll();
    Optional<ProductEntity> getById(int id);
    Optional<ProductEntity> save(ProductModel request);
    Optional<ProductEntity> update(ProductModel request, int id);
    Optional<ProductEntity> delete(int id);
}
