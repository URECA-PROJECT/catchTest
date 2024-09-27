package com.ureca.myspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ureca.myspring.dto.QuestionDTO;
import com.ureca.myspring.service.QuestionService;

@RestController
@CrossOrigin(origins="*")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	// 모든 폼 항목
	@GetMapping("/questions")
	public List<QuestionDTO> listQuestion() {
		return questionService.listQuestion();
	}
	
	@PostMapping("/questions")
	public Map<String, Object> saveQuestions(@RequestBody List<QuestionDTO> questions) {
		System.out.println("Questions: "+questions);
		questionService.saveQuestions(questions);
		Map<String,Object> result = new HashMap<>();
		result.put("code","ok");
		return result;
	}
	
	
	// 특정 매장의 질문만 조회
	@GetMapping("/questions/{store_id}")
	public List<QuestionDTO> getQuestionById(@PathVariable("store_id") int storeID) {
		return questionService.getQuestionById(storeID);
	}
}
