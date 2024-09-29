package com.ureca.myspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ureca.myspring.dto.QuestionDTO;
import com.ureca.myspring.service.QuestionService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/questions") // 공통 경로
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	// 모든 폼 항목
	@GetMapping
	public List<QuestionDTO> listQuestion() {
		return questionService.listQuestion();
	}
	
	@PostMapping
	public Map<String, Object> saveQuestion(@RequestBody QuestionDTO question) {
		questionService.saveQuestion(question);
		Map<String,Object> result = new HashMap<>();
		result.put("code","ok");
		return result;
	}
	
	// 특정 매장의 질문 목록 조회
	@GetMapping("/{store_id}")
	public List<QuestionDTO> getQuestionById(@PathVariable("store_id") int storeID) {
		return questionService.getQuestionById(storeID);
	}
	
	@PutMapping("delete/{id}")
	public Map<String, Object> deleteQuestion(@PathVariable("id") int id) {
		questionService.updateQuestionIsActive(id);
		Map<String, Object> result = new HashMap<>();
		result.put("code", "ok");
		return result;
	}
}
