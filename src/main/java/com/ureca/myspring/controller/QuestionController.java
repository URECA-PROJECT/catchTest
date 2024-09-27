package com.ureca.myspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.ureca.myspring.service.QuestionService;

@RestController
@CrossOrigin(origins="*")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
}
