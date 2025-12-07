package com.example.springpro.controllers;


import com.example.springpro.repositories.CategoryRepository;
import com.example.springpro.services.CategoryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService CategoryService;

    public void CategoryController(CategoryService categoryService){
        this.CategoryService=categoryService;
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long categoryId){
      CategoryService.deleteCategory(categoryId);
    }

}
