package com.example.products.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    private String id;
    private String name_prod;
    private String description;
    private String image;

}
