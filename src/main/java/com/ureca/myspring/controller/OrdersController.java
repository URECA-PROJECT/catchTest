package com.ureca.myspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ureca.myspring.dto.OrdersDTO;
import com.ureca.myspring.service.OrdersService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    // 주문 생성
    @PostMapping
    public OrdersDTO createOrder(@RequestBody OrdersDTO ordersDTO) {
    	System.out.println("Received Order: " + ordersDTO);
        return ordersService.createOrder(ordersDTO);
    }
}
