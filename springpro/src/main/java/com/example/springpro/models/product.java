package com.example.springpro.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="products")
public class product  extends  BaseModel{
//    private  Long id;
    private  String title;
    private  String description;
    private String imageUrl;
    private  double price;

    @ManyToOne
    private  Category category;

}
