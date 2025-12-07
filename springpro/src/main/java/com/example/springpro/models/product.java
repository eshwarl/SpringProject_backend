package com.example.springpro.models;

import jakarta.persistence.CascadeType;
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
//this is used when we are mapping for one categoery and many products for same category
//    this are called fetch types and schema designing
    @ManyToOne(cascade= {CascadeType.REMOVE})
    private  Category category;

}
