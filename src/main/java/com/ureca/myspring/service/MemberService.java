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

   public MemberDTO getMemberById(Long id) {
      return memberRepository.findById(id).orElse(null);
   }

   // 회원 정보 업데이트 메소드
   public void updateMember(MemberDTO updatedMember) {
      // 기존 회원 정보 조회
      MemberDTO existingMember = memberRepository.findById(updatedMember.getId()).orElse(null);
      
      if (existingMember != null) {
         // 필요한 필드 업데이트 (전화번호, 비밀번호 등)
         existingMember.setPhone(updatedMember.getPhone());
         existingMember.setPassword(updatedMember.getPassword());   
         // 저장
         memberRepository.save(existingMember);
      }
   }
   
   public MemberDTO registerMember(MemberDTO memberDTO) {
      //회원정보 저장
      return memberRepository.save(memberDTO);
   }
}