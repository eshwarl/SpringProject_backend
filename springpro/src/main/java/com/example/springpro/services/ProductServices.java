package com.example.springpro.services;

import com.example.springpro.exceptions.ProductNotFound;
import com.example.springpro.models.product;


import java.util.List;

public interface ProductServices {
    product getProductById(Long productId) throws ProductNotFound;
    List<product> getAllProducts();
    product createProduct(product product);
    product replaceProduct(Long id,product product) throws ProductNotFound;
    void deleteProduct(Long id) throws ProductNotFound;



}




