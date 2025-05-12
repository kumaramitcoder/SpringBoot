package com.example.springbootexample.service;

import com.example.springbootexample.entity.Order;

import java.util.List;
import java.util.Locale;

public interface OrderService {
    List<Order> getAllOrders();

    Order getOrderById(Long id);

    Order createOrder(Order order);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);


}
