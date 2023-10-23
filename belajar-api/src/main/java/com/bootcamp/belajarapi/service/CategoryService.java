package com.bootcamp.belajarapi.service;

import com.bootcamp.belajarapi.entity.CategoryEntity;
import com.bootcamp.belajarapi.model.CategoryRequest;
import com.bootcamp.belajarapi.model.CategoryResponse;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryResponse> getAll();
    Optional<CategoryResponse> getById(int id);
    Optional<CategoryResponse> save(CategoryRequest request);
    Optional<CategoryResponse> update(CategoryRequest request, int id);
    Optional<CategoryResponse> delete(int id);
}
