package com.bootcamp.belajarapi.service;

import com.bootcamp.belajarapi.entity.CategoryEntity;
import com.bootcamp.belajarapi.model.CategoryRequest;
import com.bootcamp.belajarapi.model.CategoryResponse;
import com.bootcamp.belajarapi.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository repository;

    // constructor
    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CategoryResponse> getAll() {
        List<CategoryEntity> result = this.repository.findAll();
        if(result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream().map(CategoryResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryResponse> getById(int id) {
        CategoryEntity entity = this.repository.findById(id).orElse(null);
        if(entity == null){
            return Optional.empty();
        }
        return Optional.of(new CategoryResponse(entity));
    }

    @Override
    public Optional<CategoryResponse> save(CategoryRequest request) {
        CategoryEntity entity = new CategoryEntity(request);
        try {
            this.repository.saveAndFlush(entity);
            return Optional.of(new CategoryResponse(entity));
        }catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryResponse> update(CategoryRequest request, int id) {
        // find data
        CategoryEntity entity = this.repository.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }
        // update data
        BeanUtils.copyProperties(request, entity);
        // save ke database
        try {
            this.repository.saveAndFlush(entity);
            return Optional.of(new CategoryResponse(entity));
        }catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryResponse> delete(int id) {
        // find data
        CategoryEntity entity = this.repository.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        // save ke database
        try {
            this.repository.delete(entity);
            return Optional.of(new CategoryResponse(entity));
        }catch (Exception e) {
            return Optional.empty();
        }
    }
}
