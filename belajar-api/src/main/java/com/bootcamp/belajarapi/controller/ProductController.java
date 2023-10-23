package com.bootcamp.belajarapi.controller;

import com.bootcamp.belajarapi.entity.ProductEntity;
import com.bootcamp.belajarapi.model.ProductModel;
import com.bootcamp.belajarapi.service.ProductService;
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
    public List<ProductEntity> getAll(){
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public ProductEntity getById(@PathVariable("id") int id){
        return this.service.getById(id).orElse(new ProductEntity());
    }

    @PostMapping
    public ProductEntity save(@RequestBody ProductModel request){
        return this.service.save(request).orElse(null);
    }
}
