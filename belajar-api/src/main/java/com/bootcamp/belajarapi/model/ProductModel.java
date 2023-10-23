package com.bootcamp.belajarapi.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
