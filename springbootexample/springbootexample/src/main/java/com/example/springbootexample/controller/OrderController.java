package com.example.springbootexample.controller;

import com.example.springbootexample.entity.Order;
import com.example.springbootexample.entity.Product;
import com.example.springbootexample.serviceImpl.OrderserviceImpl;
import org.springframework.http.HttpStatus;
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
    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        return new ResponseEntity<>(orderservice.getOrderById(id), HttpStatus.OK);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderservice.createOrder(order), HttpStatus.CREATED);
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable Long id){
        Order order1 = orderservice.updateOrder(id, order);
        return new ResponseEntity<>(order1, HttpStatus.OK);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id){
        orderservice.deleteOrder(id);
        return  ResponseEntity.ok("order with ID "+id+" deleted Successfully ");
    }



}
