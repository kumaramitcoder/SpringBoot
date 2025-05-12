package com.example.springbootexample.serviceImpl;

import com.example.springbootexample.entity.Order;
import com.example.springbootexample.exception.ResourceNotFoundException;
import com.example.springbootexample.repository.OrderRepository;
import com.example.springbootexample.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderserviceImpl implements OrderService {

    private final OrderRepository orderRepository;

    OrderserviceImpl(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }


    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found with id"+id));

    }

    public Order createOrder(Order order){
        if (order.getProduct()==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product must be greater than 0");
        }
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Order order1 = getOrderById(id);
        order1.setCustomerName(order.getCustomerName());
        order1.setProduct(order.getProduct());
        order1.setPrice(order.getPrice());
        return orderRepository.save(order1);

    }

    @Override
    public void deleteOrder(Long id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }


}
