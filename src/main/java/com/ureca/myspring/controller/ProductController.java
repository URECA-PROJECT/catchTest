package com.ureca.myspring.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    // 특정 가게의 모든 메뉴 조회
    @GetMapping("/{storeId}")
    public List<ProductDTO> getProductsByStoreId(@PathVariable("storeId") Long storeId) {
        return productService.getProductsByStoreId(storeId);
    }
    
    // 메뉴 추가
    @PostMapping
    public Map<String, Object> addProduct(@RequestBody ProductDTO product) {
    	ProductDTO savedProduct = productService.addProduct(product);
    	Map<String, Object> result = new HashMap<>();
    	result.put("code", "ok");
    	return result;
    }
    
    // 메뉴 삭제
    @DeleteMapping("/{productId}")
    public Map<String, Object> deleteProduct(@PathVariable("productId") Long productId) {
    	productService.deleteProduct(productId);
    	Map<String, Object> result = new HashMap<>();
    	result.put("code", "ok");
    	return result;
    }
    
 // 특정 가게의 특정 메뉴 조회
    @GetMapping("/{storeId}/{productId}")
    public ProductDTO getProductByStoreIdAndProductId(
            @PathVariable("storeId") Long storeId,
            @PathVariable("productId") Long productId) {
        return productService.getProductByStoreIdAndProductId(storeId, productId);
    }

}
