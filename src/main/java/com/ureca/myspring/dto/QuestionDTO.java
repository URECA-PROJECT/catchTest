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
@Table(name="question")
public class QuestionDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="store_id")
	private long storeID; // 해당 질문이 속한 폼 번호 (폼 번호를 알면 storeId도 알 수 있음)
	
	@Column(name="question_text")
	private String questionText; // 질문
	
	@Column(name="question_type")
	private String questionType; // 입력 형식 (텍스트, 드롭다운, 날짜, 파일 업로드)
	
	@Column(name="is_active")
	private long isActive; // 질문 활성화 여부 (삭제 시 비활성화)
	
	@Column(name = "question_content", columnDefinition = "JSON")
    private String questionContent; // JSON 형식으로 배열을 저장하는 필드
	
}	
