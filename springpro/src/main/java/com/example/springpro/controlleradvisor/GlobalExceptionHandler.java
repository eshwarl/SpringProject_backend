package com.example.springpro.controlleradvisor;


import com.example.springpro.exceptions.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<String> handleProductNotFoundException(){

        return new ResponseEntity<>(
     "product with given id not found",
                HttpStatus.BAD_REQUEST
        
        );
    }
}
