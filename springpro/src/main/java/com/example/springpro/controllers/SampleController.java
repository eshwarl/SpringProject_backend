package com.example.springpro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random")
public class SampleController {

     @GetMapping("/hello/{numberOfTimes}")
    public String sayHello(@PathVariable("numberOfTimes") int numberOfTimes){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<numberOfTimes;i++){
            sb.append("eshwar\n");
        }
        return sb.toString();
//         return "Hello Springboot";
    }

//    public String sayBye(){
//
//         return "bye everyone";
//    }
}
//https://www.amazon.com/search?query='iphone'