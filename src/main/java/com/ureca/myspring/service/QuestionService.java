package com.ureca.myspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ureca.myspring.repository.QuestionRepository;

@Service
	public class QuestionService {
		@Autowired
		private QuestionRepository questionRepository;
}
