package com.ureca.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ureca.myspring.dto.RegionDTO;
import com.ureca.myspring.repository.RegionRepository;

@Service
public class RegionService {
	@Autowired
	private RegionRepository regionRepository ;
	
	public List<RegionDTO> listRegion() {
		return regionRepository.findAll();
	}
	
	// 모든 zone 조회
	public List<String> listZones() {
	    return regionRepository.findDistinctZone();
	}
	
	// 모든 city 조회
	public List<String> listCities(String zone) {
	    return regionRepository.findDistinctCity(zone);
	}
}
