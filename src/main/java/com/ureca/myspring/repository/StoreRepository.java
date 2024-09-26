package com.ureca.myspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ureca.myspring.dto.StoreDTO;

public interface StoreRepository extends JpaRepository<StoreDTO, Long> {
	// store_list_id로 스토어 조회
    StoreDTO findByStoreListId(Long storeListId);
}