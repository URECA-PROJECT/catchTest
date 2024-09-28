package com.ureca.myspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ureca.myspring.dto.MemberDTO;

public interface MemberRepository extends JpaRepository<MemberDTO, Long>{
	MemberDTO findByMemberid(String memberid);
}