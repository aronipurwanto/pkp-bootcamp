package com.bootcamp.belajarapi.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    private int id;
    @NotBlank(message = "Mohon di isi")
    private String code;
    @NotBlank(message = "Mohon di isi")
    private String name;
}
