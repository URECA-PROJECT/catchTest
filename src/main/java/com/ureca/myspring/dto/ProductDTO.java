package com.ureca.myspring.dto;

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
@Table(name = "product")
public class ProductDTO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 설정
    private Long id;
	
	@Column(name="store_id")
    private Long storeId; // 가게 ID
   
	@Column(name="name")
	private String name; // 메뉴 이름
    
    @Column(name="category_detail_id")
    private Long categoryDetailId; // 카테고리 외래키
    
    @Column(name = "price")
    private Double price; // 가격
    
    @Column(name = "description")
    private String description; // 설명
    
    @Column(name = "image")
    private byte[] image; // 이미지 필드
}
