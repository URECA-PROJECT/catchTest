package com.ureca.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ureca.myspring.dto.CategoryDTO;
import com.ureca.myspring.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository ;

	public List<CategoryDTO> listCategory() {
		return categoryRepository.findAll();
	}
}