package com.example.springpro.controllers;

import com.example.springpro.models.product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping("/{id}")
    public product getProductById(@PathVariable("id") Long id){
        return null;


    }
    @GetMapping()
    public List<product> getAllProducts(){
        return new ArrayList<>();
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
