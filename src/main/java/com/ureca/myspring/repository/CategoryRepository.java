package com.ureca.myspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ureca.myspring.dto.CategoryDTO;

public interface CategoryRepository extends JpaRepository<CategoryDTO, Long> {

}
