package com.ureca.myspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ureca.myspring.dto.QuestionDTO;

public interface QuestionRepository extends JpaRepository<QuestionDTO, Long> {
	List<QuestionDTO> findByStoreID(Long storeID);
}
