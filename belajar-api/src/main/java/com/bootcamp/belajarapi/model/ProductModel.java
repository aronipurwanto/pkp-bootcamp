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
public class ProductModel {
    private int id;
    @NotBlank(message = "Mohon di isi")
    private String name;
    @NotBlank(message = "Mohon di isi")
    private String description;
    private Long price;
    private int categoryId;

    public ProductModel(ProductEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
