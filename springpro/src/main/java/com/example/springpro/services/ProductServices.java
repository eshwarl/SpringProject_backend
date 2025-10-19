package com.example.springpro.services;

import com.example.springpro.models.product;

import java.util.List;

public interface ProductServices {
    product getProductById(Long productId);

    List<product> getAllProducts();
}


