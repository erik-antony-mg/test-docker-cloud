package com.example.products.services;


import com.example.products.entities.Product;
import com.example.products.entities.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

   List<Product> listProducts();
   Product createProduct(ProductDto productDto);
}
