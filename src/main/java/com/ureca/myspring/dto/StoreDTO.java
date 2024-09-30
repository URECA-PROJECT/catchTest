package com.ureca.myspring.dto;

import java.time.LocalTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
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

    @Column(name = "openTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime openTime;

    @Column(name = "closeTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime closeTime;
    private Long storeListId; // 참조 필드
    private String image; // 이미지 필드 추가
    
}
