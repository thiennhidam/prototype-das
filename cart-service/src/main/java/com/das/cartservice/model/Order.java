package com.das.cartservice.model;

public class Order {
    private int id;
    private int userId;
    private Product product;

    public Order(){}

    public Order(int id, int userId, Product product){
        this.id = id;
        this.userId = userId;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
