package com.example.springpro.exceptions;

public class ProductNotFound  extends Exception{
    public ProductNotFound(String message){
        super(message);
    }
}
