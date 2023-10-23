package com.bootcamp.belajarapi.service;

import com.bootcamp.belajarapi.entity.ProductEntity;
import com.bootcamp.belajarapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository repository;

    // constructor
    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductEntity> getAll() {
        return this.repository.findAll();
    }
}
