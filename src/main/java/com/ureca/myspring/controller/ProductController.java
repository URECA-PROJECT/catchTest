package com.ureca.myspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ureca.myspring.dto.ProductDTO;
import com.ureca.myspring.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*") // 클라이언트의 주소
public class ProductController {

    @Autowired
    private ProductService productService;

    // 전체 메뉴 조회
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    // 특정 가게의 메뉴 조회
    @GetMapping("/store/{storeId}")
    public List<ProductDTO> getProductsByStoreId(@PathVariable("storeId") Long storeId) {
        return productService.getProductsByStoreId(storeId);
    }

}
