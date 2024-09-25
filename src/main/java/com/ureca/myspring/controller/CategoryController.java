package com.ureca.myspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ureca.myspring.dto.CategoryDTO;
import com.ureca.myspring.service.CategoryService;

@RestController
@CrossOrigin(origins = "*") // 클라이언트의 주소
@RequestMapping("/category") // 공통 경로
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	// 모든 카테고리 정보
    @GetMapping
    public List<CategoryDTO> listCategory() {        
        return categoryService.listCategory();
    }
}
