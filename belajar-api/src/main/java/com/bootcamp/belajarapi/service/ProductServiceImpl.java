package com.bootcamp.belajarapi.service;

import com.bootcamp.belajarapi.entity.CategoryEntity;
import com.bootcamp.belajarapi.entity.ProductEntity;
import com.bootcamp.belajarapi.model.ProductModel;
import com.bootcamp.belajarapi.repository.CategoryRepository;
import com.bootcamp.belajarapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository;
    private final CategoryRepository categoryRepo;

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
        CategoryEntity category = this.categoryRepo.findById(request.getCategoryId()).orElse(null);
        if(category == null){
            return Optional.empty();
        }

        ProductEntity entity = new ProductEntity(request);
        try {
            this.repository.saveAndFlush(entity);
            return Optional.of(entity);
        }catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductEntity> update(ProductModel request, int id) {
        CategoryEntity category = this.categoryRepo.findById(request.getCategoryId()).orElse(null);
        if(category == null){
            return Optional.empty();
        }

        // find data
        ProductEntity entity = this.repository.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }
        // update data
        BeanUtils.copyProperties(request, entity);
        // save ke database
        try {
            this.repository.saveAndFlush(entity);
            return Optional.of(entity);
        }catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductEntity> delete(int id) {
        // find data
        ProductEntity entity = this.repository.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        // save ke database
        try {
            this.repository.delete(entity);
            return Optional.of(entity);
        }catch (Exception e) {
            return Optional.empty();
        }
    }
}
