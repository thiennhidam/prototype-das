package com.das.cartservice.model;

import java.util.HashMap;
import java.util.List;

public class OrderData {
    private int id;
    private int userId;
    private List<OrderedProduct> orderedProducts;
    private HashMap<Integer, Integer> productIdAndQuantity;
    private String shippingAddress;
    private int status;
    private String time;

    public OrderData() {
    }

    public OrderData(int id, int userId, List<OrderedProduct> orderedProducts, HashMap<Integer, Integer> productIdAndQuantity, String shippingAddress, int status, String time) {
        this.id = id;
        this.userId = userId;
        this.orderedProducts = orderedProducts;
        this.productIdAndQuantity = productIdAndQuantity;
        this.shippingAddress = shippingAddress;
        this.status = status;
        this.time = time;
    }

    public HashMap<Integer, Integer> getProductIdAndQuantity() {
        return productIdAndQuantity;
    }

    public void setProductIdAndQuantity(HashMap<Integer, Integer> productIdAndQuantity) {
        this.productIdAndQuantity = productIdAndQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
