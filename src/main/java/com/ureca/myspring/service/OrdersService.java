package com.ureca.myspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ureca.myspring.dto.OrdersDTO;
import com.ureca.myspring.repository.OrdersRepository;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    
    // 주문 생성
    public OrdersDTO createOrder(OrdersDTO ordersDTO) {
        return ordersRepository.save(ordersDTO);
    }
}
