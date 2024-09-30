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
@Table(name="reservation_time")
public class ReservationTimeDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id 자동 증가
	private Long id;
	
	@Column(name="store_id", nullable = false)
	private Long storeId;
	
	@Column(name="year", nullable=false)
	private int year;
	
	@Column(name = "month", nullable = false)
    private int month;

    @Column(name = "day", nullable = false)
    private int day;

    @Column(name = "time", nullable = false)
    private String time;
	
}
