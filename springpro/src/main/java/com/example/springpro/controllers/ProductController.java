package com.example.springpro.controllers;

import com.example.springpro.models.product;
import com.example.springpro.services.ProductServices;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductServices productservices;
    public ProductController(ProductServices productServices){
        this.productservices=productServices;

    }
    @GetMapping("/{id}")
    public product getProductById(@PathVariable("id") Long id){
        return productservices.getProductById(id);


    }
    @GetMapping()
    public List<product> getAllProducts(){
        return productservices.getAllProducts();
    }

    @PostMapping()
    public product createProduct(@RequestBody product product){
        return null;

    }
    @PatchMapping("/{id}")
    public product UpdateProduct(@PathVariable("id") Long productId,  @RequestBody product product){
        return null;
    }

    @PutMapping("/{id}")
    public product replaceProduct(@PathVariable("id") Long productId,  @RequestBody product product){
        return null;
    }


}
