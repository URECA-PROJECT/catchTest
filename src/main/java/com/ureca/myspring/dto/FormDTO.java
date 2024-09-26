package com.ureca.myspring.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="form")
public class FormDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int version; // 폼 항목이 바뀔 때마다 version +1
	
	@Column(name="store_id")
	private int storeId; // 해당 폼을 생성한 매장 번호
}
