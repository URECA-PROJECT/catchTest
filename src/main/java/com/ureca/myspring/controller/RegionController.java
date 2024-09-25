package com.ureca.myspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ureca.myspring.dto.RegionDTO;
import com.ureca.myspring.service.RegionService;

@RestController
@CrossOrigin(origins = "*") // 클라이언트의 주소
@RequestMapping("/region") // 공통 경로
public class RegionController {
	@Autowired
	private RegionService regionService;
	
	// 모든 지역 정보	
    @GetMapping
    public List<RegionDTO> listRegion() {        
        return regionService.listRegion();
    }
    
 	// 모든 zone 조회(서울특별시, 경기도, 인천광역시 등)
    @GetMapping("/zone")
    public List<String> listZones() {
        return regionService.listZones();
    }
    
    // 요청된 zone의 모든 city 조회
    @GetMapping("/cities")
    public List<String> listCities(@RequestParam(value = "zone") String zone) {
        return regionService.listCities(zone);
    }
}
