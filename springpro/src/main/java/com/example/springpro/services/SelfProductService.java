package com.example.springpro.services;

import com.example.springpro.exceptions.ProductNotFound;
import com.example.springpro.models.product;
import com.example.springpro.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
//@Primary
public class SelfProductService implements ProductServices{

    private ProductRepository productRepository;
    public SelfProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @Override
    public product getProductById(Long ProductId) throws ProductNotFound {
       Optional<product> OptionalProduct= productRepository.findById(ProductId);
       if(OptionalProduct.isEmpty()){
           throw new ProductNotFound("product with Id"+ProductId+"not found");
       }
     return  OptionalProduct.get();



    }
    @Override
    public List<product> getAllProducts() {
        // implementation
        return new ArrayList<>();
    }

    @Override
    public product createProduct(product product){
        return productRepository.save(product);
    }

}
