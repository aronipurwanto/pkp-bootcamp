package com.bootcamp.belajarapi.service;

import com.bootcamp.belajarapi.entity.ProductEntity;
import com.bootcamp.belajarapi.model.ProductModel;
import com.bootcamp.belajarapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<ProductEntity> getById(int id) {
        return this.repository.findById(id);
    }

    @Override
    public Optional<ProductEntity> save(ProductModel request) {
        ProductEntity entity = ProductEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        try {
            this.repository.saveAndFlush(entity);
            return Optional.of(entity);
        }catch (Exception e) {
            return Optional.empty();
        }
    }
}
