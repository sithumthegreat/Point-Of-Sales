package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.OrderEntity;
import com.example.demo.service.OrderService;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<OrderEntity> getAll() throws Exception{
        return orderService.getAll();
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order)throws Exception{
        try {
            OrderEntity newOrder=orderService.createOrder(order);
            return ResponseEntity.status(200).body(newOrder);
            
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(400).body(null);
        }
    }


}
