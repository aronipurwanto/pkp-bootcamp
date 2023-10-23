package com.bootcamp.belajarapi.repository;

import com.bootcamp.belajarapi.entity.CategoryEntity;
import com.bootcamp.belajarapi.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
