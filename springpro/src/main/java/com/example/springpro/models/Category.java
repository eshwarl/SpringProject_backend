package com.example.springpro.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="categories")
public class Category extends  BaseModel {
//    used base model and inherted common model attributes
//    private Long id;
    private String name;

}
