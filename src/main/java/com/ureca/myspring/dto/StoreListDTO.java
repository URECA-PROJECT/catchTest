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
@Table(name="store_list")
public class StoreListDTO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
	
	@Column(name="store")
    private String store;   
    
    @Column(name = "region_id")
    private Long regionId;  
    
    @Column(name = "category_id")
    private Long categoryId;  
    
    @Column(name = "category_detail_id")
    private Long categoryDetailId;  
    
    @Column(name="member_id")
    private Long memberId;
    
    @Column(name="stord_id")
    private Long storeId;
}
