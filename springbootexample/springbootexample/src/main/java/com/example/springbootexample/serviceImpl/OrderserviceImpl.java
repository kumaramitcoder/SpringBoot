package com.example.springbootexample.serviceImpl;

import com.example.springbootexample.entity.Order;
import com.example.springbootexample.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderserviceImpl {

    private final OrderRepository orderRepository;

    OrderserviceImpl(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }


    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Order order){
        return orderRepository.save(order);
    }


}
