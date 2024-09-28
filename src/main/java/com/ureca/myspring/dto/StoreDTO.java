package com.ureca.myspring.dto;

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
@Table(name="store")
public class StoreDTO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 설정
	private Long id;
    private String store;
    private String content;
    private String address;
    private String closeDay; // 여러 날을 저장하기 위한 문자열
    private String openTime;
    private String closeTime;
    private Long storeListId; // 참조 필드
    private String image; // 이미지 필드 추가
}
