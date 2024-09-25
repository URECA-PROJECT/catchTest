package com.ureca.myspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ureca.myspring.dto.StoreListDTO;

public interface StoreListRepository extends JpaRepository<StoreListDTO, Long>{
	 List<StoreListDTO> findByRegionIdAndCategoryId(Long regionId, Long categoryId);
}
