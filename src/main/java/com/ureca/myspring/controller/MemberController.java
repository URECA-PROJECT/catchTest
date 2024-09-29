package com.ureca.myspring.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;

import com.ureca.myspring.dto.MemberDTO;
import com.ureca.myspring.service.FileStorageService;
import com.ureca.myspring.service.MemberService;

@RestController
@CrossOrigin(origins = "*")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private FileStorageService fileStorageService;
    
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
   
    @PostMapping("/signup")
    public ResponseEntity<String> registerMember(@RequestBody MemberDTO memberDTO) {
        memberService.registerMember(memberDTO);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }
    
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody MemberDTO memberDTO) {
        MemberDTO existingMember = memberService.getMemberByMemberId(memberDTO.getMemberid());

        if (existingMember != null && existingMember.getPassword().equals(memberDTO.getPassword())) {
            // 로그인 성공
            existingMember.setPassword(null); // 비밀번호 제거

            // 응답 데이터 생성
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("data", existingMember); // 회원 정보를 "data" 키로 저장

            return ResponseEntity.ok(responseData); // 회원 정보 포함된 응답 반환
        } else {
            // 로그인 실패
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
    
    
    

    // 회원 정보 업데이트
    @PostMapping("/members/update")
    public Map<String, Object> updateMember(
            @RequestPart("member") MemberDTO member, 
            @RequestPart(value = "profileImage", required = false) MultipartFile profileImage) {
    
    	// ID 체크
        if (member.getId() == null) {
            throw new IllegalArgumentException("The given id must not be null");
        }
        
        // 프로필 이미지 처리
        if (profileImage != null && !profileImage.isEmpty()) {
            String filePath = fileStorageService.storeFile(profileImage);  // 파일 저장
            member.setProfileImage(filePath);  // 경로를 DTO의 profileImage 필드에 저장
        }
        

        // 멤버 정보 업데이트
        MemberDTO updatedMember = memberService.updateMember(member);
        
        Map<String, Object> result = new HashMap<>();
        result.put("code", "ok");
        result.put("updatedMember", updatedMember); // 수정된 멤버 정보 추가
        return result;
    }
    

}
