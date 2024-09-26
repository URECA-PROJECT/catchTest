package com.ureca.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ureca.myspring.dto.ProductDTO;
import com.ureca.myspring.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll();
    }

    public List<ProductDTO> getProductsByStoreId(Long storeId) {
        return productRepository.findByStoreId(storeId);
    }
}
