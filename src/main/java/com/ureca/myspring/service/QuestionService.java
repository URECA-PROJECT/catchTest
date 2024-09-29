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

		public List<QuestionDTO> getQuestionById(long storeID) {
			return questionRepository.findByStoreID(storeID);
		}

		public void saveQuestion(QuestionDTO question) {
			System.out.println("Question: "+question);
			questionRepository.save(question);
		}

		// 질문을 업데이트하여 isActive를 0으로 설정
		public void updateQuestionIsActive(long id) {
			QuestionDTO question = questionRepository.findById(id).orElse(null);
			if (question != null) {
				question.setIsActive(0);
				questionRepository.save(question);
			}
		}
}
