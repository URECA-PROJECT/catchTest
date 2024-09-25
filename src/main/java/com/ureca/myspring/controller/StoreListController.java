package com.ureca.myspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ureca.myspring.dto.StoreListDTO;
import com.ureca.myspring.service.StoreListService;

@RestController
@CrossOrigin(origins = "*") // 클라이언트의 주소
@RequestMapping("/storeList") // 공통 경로
public class StoreListController {
	@Autowired
	private StoreListService storeListService;
	
	// 모든 가게 정보
    @GetMapping
    public List<StoreListDTO> listStoreList() {        
        return storeListService.listStoreList();
    }
}
