package com.ureca.myspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ureca.myspring.dto.CategoryDetailDTO;

public interface CategoryDetailRepository extends JpaRepository<CategoryDetailDTO, Long>{
	// 특정 categoryId에 해당하는 세부 카테고리 조회
    List<CategoryDetailDTO> findByCategoryId(Long categoryId);
}
