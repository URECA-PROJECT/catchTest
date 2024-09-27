package com.ureca.myspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ureca.myspring.dto.StoreListDTO;

public interface StoreListRepository extends JpaRepository<StoreListDTO, Long>{
	List<StoreListDTO> findByRegionIdAndCategoryDetailId(Long regionId, Long categoryDetailId);
}
