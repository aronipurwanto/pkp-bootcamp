package com.bootcamp.belajarapi.model;

import com.bootcamp.belajarapi.entity.ProductEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private int id;
    private String name;
    private String description;
    private Long price;
    private int categoryId;
    private String categoryName;

    public ProductResponse(ProductEntity entity) {
        BeanUtils.copyProperties(entity, this);
        if(entity.getCategory() != null){
            this.categoryName = entity.getCategory().getName();
        }
    }
}
