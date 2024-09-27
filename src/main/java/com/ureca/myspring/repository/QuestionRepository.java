package com.ureca.myspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ureca.myspring.dto.QuestionDTO;

public interface QuestionRepository extends JpaRepository<QuestionDTO, Integer> {

}
