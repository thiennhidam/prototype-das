package com.das.productservice.controller;

import com.das.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class ProductController {

//    @Autowired
//    private RestTemplate restTemplate;

    @RequestMapping("/get")
    public Product getProduct(){

        return new Product(1, "Macbook Pro 2016", "This is a product from Apple");
    }
}
