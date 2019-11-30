package com.das.cartservice.controller;

import com.das.cartservice.model.*;
import com.das.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/")
public class CartController {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    //    @RequestMapping("/get")
//    public Order getProduct(){
////        RestTemplate restTemplate = new RestTemplate();
//
////        WebClient.Builder builder = WebClient.builder();
////        Product product = new Product(1,"Macbook", "Desc");
//        Product product = restTemplate.getForObject("http://product-service/get", Product.class);
////        Product product = webClientBuilder.build()
////                .get()
////                .uri("http://localhost:8081/prod/get")
////                .retrieve()
////                .bodyToMono(Product.class)
////                .block();
//        return new Order(1, 1, product);
//    }

    @RequestMapping("/add-order")
    public ResponseEntity addOrder(@RequestParam("userId") Integer userId, @RequestParam("productId") Integer productId[]){
        UserData userData = restTemplate.getForObject("http://user-service/get/"+userId, UserData.class);
        if(userData != null){
            boolean ok = cartService.addNewOrder(userData, productId);
            if(ok) return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @RequestMapping("/get-order-list/{id}")
    public ResponseEntity getOrderListByUserId(@PathVariable("id") Integer userId){
        List<OrderData> orderDataList = cartService.getOrderListByUserId(userId);
        List<OrderedProduct> orderedProducts = new ArrayList<>();
        if(orderDataList != null){
            for (int i = 0; i < orderDataList.size(); i++) {
                OrderData od = orderDataList.get(i);
                HashMap<Integer, Integer> productAndQuantity = od.getProductIdAndQuantity();
                for(Map.Entry<Integer, Integer> entry : productAndQuantity.entrySet()){
                    Product product = restTemplate.getForObject("http://product-service/get/" + entry.getKey(), Product.class);
                    if(product != null){
                        OrderedProduct op = new OrderedProduct(product, entry.getValue());
                        orderedProducts.add(op);
                    }
                }
                od.setOrderedProducts(orderedProducts);
                orderDataList.set(i, od);
            }
            return ResponseEntity.status(HttpStatus.OK).body(orderDataList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
