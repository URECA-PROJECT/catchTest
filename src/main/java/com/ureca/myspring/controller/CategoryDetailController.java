package com.ureca.myspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ureca.myspring.dto.CategoryDetailDTO;
import com.ureca.myspring.service.CategoryDetailService;

@RestController
@CrossOrigin(origins = "*") // 클라이언트의 주소
@RequestMapping("/categoryDetail") // 공통 경로
public class CategoryDetailController {
	@Autowired
	private CategoryDetailService categoryDetailService;
	
	// 모든 카테고리 정보
    @GetMapping
    public List<CategoryDetailDTO> listCategoryDetail() {        
        return categoryDetailService.listCategoryDetail();
    }
    
    // 특정 categoryId에 해당하는 세부 카테고리 조회
    @GetMapping("/{categoryId}")
    public List<CategoryDetailDTO> listCategoryDetailByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return categoryDetailService.listCategoryDetailByCategoryId(categoryId);
    }

}
