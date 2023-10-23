package com.bootcamp.belajarapi.service;

import com.bootcamp.belajarapi.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductEntity> getAll();
    Optional<ProductEntity> getById(int id);
}
