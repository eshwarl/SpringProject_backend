package com.example.springpro.services;

import com.example.springpro.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
private CategoryRepository categoryRepository;

public CategoryService(CategoryRepository categoryRepository){
    this.categoryRepository=categoryRepository;
}
public void deleteCategory(Long id){
    categoryRepository.deleteById(id);
}


}
