package com.example.products.services.impl;

import com.example.products.entities.Product;
import com.example.products.entities.dto.ProductDto;
import com.example.products.repositories.ProductRepository;
import com.example.products.services.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;
    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        Product product= modelMapper.map(productDto,Product.class);
        productRepository.save(product);
        return product;
    }


}
