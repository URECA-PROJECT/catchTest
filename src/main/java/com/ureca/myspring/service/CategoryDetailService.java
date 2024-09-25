package com.ureca.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ureca.myspring.dto.CategoryDetailDTO;
import com.ureca.myspring.repository.CategoryDetailRepository;

@Service
public class CategoryDetailService {
	@Autowired
	private CategoryDetailRepository categoryDetailRepository ;

	public List<CategoryDetailDTO> listCategoryDetail() {
		return categoryDetailRepository.findAll();
	}
	
    // 특정 카테고리 ID에 해당하는 세부 카테고리 조회
    public List<CategoryDetailDTO> listCategoryDetailByCategoryId(Long categoryId) {
        return categoryDetailRepository.findByCategoryId(categoryId);
    }
}