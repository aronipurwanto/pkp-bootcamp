package com.bootcamp.belajarapi.controller;

import com.bootcamp.belajarapi.entity.CategoryEntity;
import com.bootcamp.belajarapi.model.CategoryRequest;
import com.bootcamp.belajarapi.model.CategoryResponse;
import com.bootcamp.belajarapi.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<CategoryResponse> getAll(){
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public CategoryResponse getById(@PathVariable("id") int id){
        return this.service.getById(id).orElse(null);
    }

    @PostMapping
    public CategoryResponse save(@Valid @RequestBody CategoryRequest request){
        return this.service.save(request).orElse(null);
    }

    @PatchMapping("/{id}")
    public CategoryResponse update(@Valid @RequestBody CategoryRequest request,
                                @PathVariable("id") int id){
        return this.service.update(request, id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public CategoryResponse delete(@PathVariable("id") int id){
        return this.service.delete(id).orElse(null);
    }
}
