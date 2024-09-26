package com.ureca.myspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreListWithDetailsDTO {
    private Long storeId;
    private String storeName;
    private String regionName;
    private String categoryDetailName;
}
