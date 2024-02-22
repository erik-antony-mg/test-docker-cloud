package com.example.products.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponse {
    private String id;
    private String name_prod;
    private String description;
    private String image;

}
