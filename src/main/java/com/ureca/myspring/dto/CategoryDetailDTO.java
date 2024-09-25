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
@Table(name="category_detail")
public class CategoryDetailDTO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            // 세부 카테고리 ID
    private String name;        // 세부 카테고리 이름
    
    @Column(name = "category_id")
    private Long categoryId;   // 해당 세부 카테고리가 속하는 카테고리 ID
}