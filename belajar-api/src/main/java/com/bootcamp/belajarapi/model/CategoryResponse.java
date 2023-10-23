package com.bootcamp.belajarapi.model;

import com.bootcamp.belajarapi.entity.CategoryEntity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private int id;
    private String code;
    private String name;
    private List<ProductModel> products;

    public CategoryResponse(CategoryEntity entity) {
        BeanUtils.copyProperties(entity, this);
        if(!entity.getProducts().isEmpty()){
            this.products = entity.getProducts().stream()
                    .map(ProductModel::new)
                    .collect(Collectors.toList());
        }
    }
}
