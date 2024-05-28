package com.mzm.Fitpin.controller;

import com.mzm.Fitpin.entity.Order;
import com.mzm.Fitpin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return ResponseEntity.ok().build();
    }
}
