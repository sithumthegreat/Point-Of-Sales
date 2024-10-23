package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.OrderEntity;
import com.example.demo.repository.OrderRepository;

import jakarta.persistence.criteria.Order;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderEntity createOrder(OrderEntity order) throws Exception {
        // TODO Auto-generated method stub
        return orderRepository.save(order);
    }

    @Override
    public List<OrderEntity> getAll() throws Exception {
        // TODO Auto-generated method stub
        return orderRepository.findAll();
    }

}
