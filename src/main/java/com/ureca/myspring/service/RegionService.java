package com.ureca.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ureca.myspring.dto.RegionDTO;
import com.ureca.myspring.repository.RegionRepository;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

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

	public List<RegionDTO> listCitiesWithId(String zone) {
	    return regionRepository.findByZone(zone);
	}
	
	// 모든 city 조회
	public List<String> listCities(String zone) {
	    return regionRepository.findDistinctCity(zone);
	}
	
	public RegionDTO getRegionById(Long regionId) {
        return regionRepository.findById(regionId)
                .orElseThrow(() -> new RuntimeException("Region not found"));
    }
}
