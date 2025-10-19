package com.example.springpro.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class product  extends  BaseModel{
//    private  Long id;
    private  String title;
    private  String description;
    private String imageUrl;
    private  double price;
    private  Category category;

}
