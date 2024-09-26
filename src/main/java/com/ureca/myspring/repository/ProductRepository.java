package com.ureca.myspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ureca.myspring.dto.ProductDTO;

public interface ProductRepository extends JpaRepository<ProductDTO, Long> {
    List<ProductDTO> findByStoreId(Long storeId); // 가게 ID로 메뉴 조회
}