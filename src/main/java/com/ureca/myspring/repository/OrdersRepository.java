package com.ureca.myspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ureca.myspring.dto.OrdersDTO;

public interface OrdersRepository extends JpaRepository<OrdersDTO, Long> {

}
