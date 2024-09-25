package com.ureca.myspring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ureca.myspring.repository.MemberRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ureca.myspring.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	

	public List<MemberDTO> listMember() {
		return memberRepository.findAll();
	}
}
