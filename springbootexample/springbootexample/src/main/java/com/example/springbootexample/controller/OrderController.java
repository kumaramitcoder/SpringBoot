package com.example.springbootexample.controller;

import com.example.springbootexample.entity.Order;
import com.example.springbootexample.serviceImpl.OrderserviceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private  final OrderserviceImpl orderservice;

    public OrderController(OrderserviceImpl orderservice){
        this.orderservice=orderservice;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderservice.getAllOrders());
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Order> getOrderById(@RequestBody Order order){
        return ResponseEntity.ok(orderservice.getOrderById(order));
    }

}
