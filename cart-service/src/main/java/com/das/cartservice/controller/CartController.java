package com.das.cartservice.controller;

import com.das.cartservice.model.Order;
import com.das.cartservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class CartController {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @RequestMapping("/get")
    public Order getProduct(){
//        RestTemplate restTemplate = new RestTemplate();

//        WebClient.Builder builder = WebClient.builder();
//        Product product = new Product(1,"Macbook", "Desc");
        Product product = restTemplate.getForObject("http://product-service/get", Product.class);
//        Product product = webClientBuilder.build()
//                .get()
//                .uri("http://localhost:8081/prod/get")
//                .retrieve()
//                .bodyToMono(Product.class)
//                .block();
        return new Order(1, 1, product);
    }
}
