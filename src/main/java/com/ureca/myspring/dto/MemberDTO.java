package com.ureca.myspring.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="member")
public class MemberDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                  // 고유키 (AUTO_INCREMENT)
    private String memberid;  
    private String name;   
    private String password;          // 비밀번호 (NOT NULL)
    private String phone;             // 전화번호
    private LocalDate birth;          // 생년월일
    private String gender;            // 성별 (M: 남성, F: 여성 등)
    private String region;           // 주소
    private String role;              // 역할 (기본값: 'user')
    
    @Column(name = "profile_image")
    private String profileImage;
}
