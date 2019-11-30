package com.das.cartservice.service;

import com.das.cartservice.common.Const;
import com.das.cartservice.model.*;
import com.das.cartservice.repository.OrderDetailRepository;
import com.das.cartservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CartService {

    private final OrderRepository orderRepository;

    private final OrderDetailRepository orderDetailRepository;

    public CartService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public boolean addNewOrder(UserData userData, Integer products[]){
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        EbayOrder ebayOrder = new EbayOrder();
        ebayOrder.setUserId(userData.getId());
        ebayOrder.setShippingAddress(userData.getAddress());
        ebayOrder.setTime(currentTime);
        ebayOrder.setStatus(Const.ORDER_STATUS.CREATED.value);
        try {
            ebayOrder = orderRepository.saveAndFlush(ebayOrder);

            for (int i = 0; i < products.length; i++) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(ebayOrder.getId());
                orderDetail.setProductId(products[i]);
                orderDetail.setQuantity(1); //default
                orderDetailRepository.saveAndFlush(orderDetail);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<OrderData> getOrderListByUserId(int userId){
        List<OrderData> orderDataList = new ArrayList<>();
        List<EbayOrder> ebayOrders = orderRepository.findAllByUserId(userId);
        if(ebayOrders != null){
            for (EbayOrder ord: ebayOrders) {
                List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(ord.getId());
                if(orderDetails != null){
                    orderDataList.add(getOrderData(ord, orderDetails));
                }
            }
        }
        return orderDataList;
    }

    private OrderData getOrderData(EbayOrder ord, List<OrderDetail> orderDetails){
        OrderData orderData = new OrderData();
        orderData.setId(ord.getId());
        orderData.setUserId(ord.getUserId());
        orderData.setShippingAddress(ord.getShippingAddress());
        orderData.setTime(ord.getTime().toString());
        orderData.setStatus(ord.getStatus());

        HashMap<Integer, Integer> productIdAndQuantity = new HashMap<>();
        for(OrderDetail od: orderDetails){
            productIdAndQuantity.put(od.getProductId(), od.getQuantity());
        }
        orderData.setProductIdAndQuantity(productIdAndQuantity);

        return orderData;
    }

}
