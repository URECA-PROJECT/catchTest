package com.ureca.myspring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name="question")
public class QuestionDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="store_id")
	private int storeID; // 해당 질문이 속한 폼 번호 (폼 번호를 알면 storeId도 알 수 있음)
	
	@Column(name="question_text")
	@JsonProperty("question_text")
	private String questionText; // 질문
	
	@Column(name="question_type")
	@JsonProperty("question_type")
	private String questionType; // 입력 형식 (텍스트, 드롭다운, 날짜, 파일 업로드)
	
	@Column(name="is_active")
	private int isActive; // 질문 활성화 여부 (삭제 시 비활성화)
	
}	
