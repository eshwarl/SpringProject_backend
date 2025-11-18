package com.example.springpro.services;

import com.example.springpro.exceptions.ProductNotFound;
import com.example.springpro.models.Category;
import com.example.springpro.models.product;
import com.example.springpro.repositories.CategoryRepository;
import com.example.springpro.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
//@Primary
public class SelfProductService implements ProductServices{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;

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
        Category category=product.getCategory();
        //before saving the product in db,we should first check if categeory is present or not
        Optional<Category> optionalCategory=categoryRepository.findByName(category.getName());
        if(optionalCategory.isEmpty()){
           category= categoryRepository.save(category);

        }
        product.setCategory(category);



        return productRepository.save(product);
    }
    @Override
    public product replaceProduct(Long id, product product) throws ProductNotFound {
        Optional<product> productOptional=productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotFound("product with Id"+ id +"not found");

        }
        product productFromDB=productOptional.get();

        productFromDB.setTitle(product.getTitle());
        productFromDB.setImageUrl(product.getImageUrl());
        productFromDB.setDescription(product.getDescription());
        productFromDB.setPrice(product.getPrice());
        Category category=product.getCategory();
        if(product.getCategory().getId()==null){
//            save the category first and then make the entry
            category=categoryRepository.save(category);
        }

        productFromDB.setCategory(category);

        return productRepository.save(productFromDB);
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFound {
         productRepository.deleteById(id);
    }

}
