package com.example.products.controllers;

import com.example.products.entities.Product;
import com.example.products.entities.dto.ProductDto;
import com.example.products.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {

    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> listProducts(){
        return ResponseEntity.ok(productService.listProducts());
    }

    @PostMapping("/crear")
    public ResponseEntity<Product> crearProdcut(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }
}
