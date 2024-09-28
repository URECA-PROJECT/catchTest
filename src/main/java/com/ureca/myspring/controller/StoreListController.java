package com.ureca.myspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ureca.myspring.dto.StoreListDTO;
import com.ureca.myspring.dto.StoreListWithDetailsDTO;
import com.ureca.myspring.service.StoreListService;

@RestController
@CrossOrigin(origins = "*") // 클라이언트의 주소
@RequestMapping("/storelist") // 공통 경로
public class StoreListController {
	@Autowired
	private StoreListService storeListService;
	
	// 모든 가게 정보
    @GetMapping
    public List<StoreListDTO> getStoreList() {        
        return storeListService.listStoreList();
    }
    
    // 지역과 카테고리로 필터링된 가게 정보 조회
    @GetMapping("/filtered")
    public List<StoreListWithDetailsDTO> listStoresByRegionAndCategoryDetail (
            @RequestParam(value = "regionId") Long regionId,
            @RequestParam(value = "categoryDetailId") Long categoryDetailId) {
    	// 데이터베이스에서 regionId와 categoryDetailId가 일치하는 가게 목록을 필터링
        return storeListService.findByRegionAndCategoryDetail(regionId, categoryDetailId);
    }
    
    @PostMapping("/register")
    public Map<String, Object> registerStore(@RequestBody StoreListDTO storeListDTO) {
    	storeListService.registerStore(storeListDTO);
    	Map<String, Object> result = new HashMap<>();
    	result.put("code", "ok");
    	return result;
    }
    
}
