package com.bootcamp.belajarapi.controller;

import com.bootcamp.belajarapi.entity.ProductEntity;
import com.bootcamp.belajarapi.model.ProductModel;
import com.bootcamp.belajarapi.model.ProductResponse;
import com.bootcamp.belajarapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductResponse> getAll(){
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable("id") int id){
        return this.service.getById(id).orElse(null);
    }

    @PostMapping
    public ProductResponse save(@Valid @RequestBody ProductModel request){
        return this.service.save(request).orElse(null);
    }

    @PatchMapping("/{id}")
    public ProductResponse update(@Valid @RequestBody ProductModel request,
                                @PathVariable("id") int id){
        return this.service.update(request, id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public ProductResponse delete(@PathVariable("id") int id){
        return this.service.delete(id).orElse(null);
    }
}
