package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.OrderEntity;
import java.util.List;

@Service
public interface OrderService {
    OrderEntity createOrder(OrderEntity order)throws Exception;
    List<OrderEntity> getAll()throws Exception;


}
