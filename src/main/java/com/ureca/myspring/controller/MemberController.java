package com.ureca.myspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.ureca.myspring.dto.MemberDTO;
import com.ureca.myspring.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	// 모든 멤버 정보
	@GetMapping("/members")
	@CrossOrigin(origins = "*")
	public List<MemberDTO> listMember(){		
		return memberService.listMember();
	}
}
