package com.ureca.myspring.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.util.Base64;
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
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    
    // 회원 정보 수정 
    @PostMapping("/members/update")
    public Map<String, Object> updateMember(
            @RequestPart("member") MemberDTO member, 
            @RequestPart(value = "profileImage", required = false) String profileImage) {
        
        // 프로필 이미지 처리
        if (profileImage != null && !profileImage.isEmpty()) {
            // 파일 저장
            String filePath = fileStorageService.storeBase64Image(profileImage);  // Base64 인코딩된 이미지 처리
            member.setProfileImage(filePath);  // 경로를 DTO의 profileImage 필드에 저장
        }
        
        // 멤버 정보 업데이트
        MemberDTO updatedMember = memberService.updateMember(member);
        
        Map<String, Object> result = new HashMap<>();
        result.put("code", "ok");
        result.put("updatedMember", updatedMember); // 수정된 멤버 정보 추가
        return result;
    }
    
    @GetMapping("/uploads/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable("fileName") String fileName) {
        try {
        	Path file = Paths.get("uploads").resolve(fileName).normalize().toAbsolutePath(); // 절대 경로로 변환

            Resource resource = new UrlResource(file.toUri());
            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, "image/jpeg") // 또는 해당 이미지의 MIME 타입
                    .body(resource);
            
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
