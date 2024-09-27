package com.ureca.myspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ureca.myspring.dto.MemberDTO;
import com.ureca.myspring.service.MemberService;

@RestController
@CrossOrigin(origins = "*")
public class MemberController {
   @Autowired
   private MemberService memberService;
   
   // 모든 멤버 정보
   @GetMapping("/members")
   public List<MemberDTO> listMember(){      
      return memberService.listMember();
   }
   
   // 특정 회원의 정보를 조회
   @GetMapping("/members/{id}")
   public MemberDTO getMemberById(@PathVariable("id") Long id) {
      return memberService.getMemberById(id);
   }
   
   // 프로필 수정 내용을 서버에서 수신
   @PostMapping("/members/update")
   public Map<String, Object> updateMember(@RequestBody MemberDTO member) {
      memberService.updateMember(member);
      Map<String, Object> result = new HashMap<>();
      result.put("code", "ok");
      return result;
   }
   
    @PostMapping("/signup")
    public ResponseEntity<String> registerMember(@RequestBody MemberDTO memberDTO) {
        memberService.registerMember(memberDTO);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberDTO memberDTO) {
        MemberDTO existingMember = memberService.getMemberByMemberId(memberDTO.getMemberid());

        if (existingMember != null && existingMember.getPassword().equals(memberDTO.getPassword())) {
            // 로그인 성공
            if ("admin".equals(existingMember.getRole())) {
                return ResponseEntity.ok("admin");
            } else {
                return ResponseEntity.ok("user");
            }
        } else {
            // 로그인 실패
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

}
