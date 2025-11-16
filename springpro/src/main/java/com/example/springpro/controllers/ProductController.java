package com.example.springpro.controllers;

import com.example.springpro.exceptions.ProductNotFound;
import com.example.springpro.models.product;
import com.example.springpro.services.ProductServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductServices productservices;
    public ProductController(@Qualifier("SelfProductService") ProductServices productServices){
        this.productservices=productServices;

    }
    @GetMapping("/{id}")
    public product  getProductById(@PathVariable("id") Long id) throws ProductNotFound{
//        ResponseEntity<product>responseEntity=null;
//        try{
//            product product=productservices.getProductById(id);
//            responseEntity=new ResponseEntity<>(
//                    product,
//                    HttpStatus.OK
//            );
//        }catch(ProductNotFound e){
//            System.out.println(e.getMessage());
//            responseEntity=new ResponseEntity<>(
//                    null,
//                    HttpStatus.BAD_REQUEST
//            );
//        }
      return productservices.getProductById(id);



    }
    @GetMapping()
    public List<product> getAllProducts(){
        return productservices.getAllProducts();
    }

    @PostMapping()
    public product createProduct(@RequestBody product product){
        return productservices.createProduct(product);

    }
    @PatchMapping("/{id}")
    public product UpdateProduct(@PathVariable("id") Long productId,  @RequestBody product product){
        return null;
    }

    @PutMapping("/{id}")
    public product replaceProduct(@PathVariable("id") Long productId,  @RequestBody product product){
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id")Long id){

    }

//    @ExceptionHandler(ProductNotFound.class)
//    public  ResponseEntity<String> handleProdctNotFound


}
