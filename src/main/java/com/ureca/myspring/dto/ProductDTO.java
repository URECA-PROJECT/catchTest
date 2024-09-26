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
@Table(name = "product")
public class ProductDTO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 설정
    private Long id;
    private Long storeId; // 가게 ID
    private String name; // 메뉴 이름
    private Long categoryDetailId; // 카테고리 외래키
    private Double price; // 가격
    private String description; // 설명
    private byte[] image; // 이미지 필드
}
