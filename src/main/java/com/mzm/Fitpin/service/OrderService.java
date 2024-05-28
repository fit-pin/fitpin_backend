package com.mzm.Fitpin.service;

import com.mzm.Fitpin.entity.Order;
import com.mzm.Fitpin.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public void addOrder(Order order) {
        orderMapper.insertOrder(order);
    }
}
