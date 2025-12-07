package com.example.springpro.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="categories")
public class Category extends  BaseModel {
//    used base model and inherted common model attributes
//    private Long id;
    @Column(unique=true)
    private String name;


    @OneToMany(mappedBy = "category",cascade= {jakarta.persistence.CascadeType.REMOVE},fetch= FetchType.EAGER)

    private List<product>products;


}
