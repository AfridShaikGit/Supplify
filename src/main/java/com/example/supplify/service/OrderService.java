package com.example.supplify.service;

import com.example.supplify.entity.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);

    List<Order> getAllOrders();
}