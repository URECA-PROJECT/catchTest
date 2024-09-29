package com.ureca.myspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ureca.myspring.repository.MemberRepository;

import jakarta.persistence.EntityNotFoundException;

import com.ureca.myspring.dto.MemberDTO;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MemberService {
    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    private MemberRepository memberRepository;

    public List<MemberDTO> listMember() {
        return memberRepository.findAll();
    }
   
    public MemberDTO getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }
   
    public MemberDTO registerMember(MemberDTO memberDTO) {
        // 회원정보 저장
        return memberRepository.save(memberDTO);
    }

    public MemberDTO getMemberByMemberId(String memberid) {
        return memberRepository.findByMemberid(memberid);
    }
    
    public MemberDTO updateMember(MemberDTO memberDTO) {
        // 기존 멤버 정보 가져오기
        Optional<MemberDTO> existingMemberOpt = memberRepository.findById(memberDTO.getId());
        if (existingMemberOpt.isPresent()) {
            MemberDTO existingMember = existingMemberOpt.get();
            
            // 전화번호 업데이트
            existingMember.setPhone(memberDTO.getPhone());
            existingMember.setPassword(memberDTO.getPassword()); // 비밀번호도 필요 시 업데이트
            existingMember.setProfileImage(memberDTO.getProfileImage()); // 프로필 이미지도 업데이트

            // 업데이트된 멤버 저장
            return memberRepository.save(existingMember);
        } else {
            throw new EntityNotFoundException("Member not found with id: " + memberDTO.getId());
        }
    }

}
