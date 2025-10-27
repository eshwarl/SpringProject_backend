package com.example.springpro.repositories;

import com.example.springpro.models.Category;
import com.example.springpro.models.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<product,Long> {
    @Override
    Optional<product> findById(Long productId);

    @Override
    List<product> findAll();
    Optional<product> findByTitleContains(String str);
    Optional<product> findByCategory(Category category);
    Optional<product>findByCattegory_Id(Long categoryId);
}
