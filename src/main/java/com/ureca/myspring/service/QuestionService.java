package com.ureca.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ureca.myspring.dto.QuestionDTO;
import com.ureca.myspring.repository.QuestionRepository;

@Service
	public class QuestionService {
		@Autowired
		private QuestionRepository questionRepository;

		public List<QuestionDTO> listQuestion() {
			return questionRepository.findAll();
		}

		public List<QuestionDTO> getQuestionById(int storeID) {
			return questionRepository.findByStoreID(storeID);
		}

		public void saveQuestions(List<QuestionDTO> questions) {
			for (QuestionDTO question: questions) {
				questionRepository.save(question);
			}
		}
}
