package com.ureca.myspring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ureca.myspring.dto.StoreListDTO;
import com.ureca.myspring.dto.StoreListWithDetailsDTO;
import com.ureca.myspring.repository.CategoryRepository;
import com.ureca.myspring.repository.RegionRepository;
import com.ureca.myspring.repository.StoreListRepository;

@Service
public class StoreListService {
	@Autowired
	private StoreListRepository storeListRepository;
	
	@Autowired
    private RegionRepository regionRepository;  // 지역 리포지토리
	
    @Autowired
    private CategoryRepository categoryRepository;  // 카테고리 리포지토리

    // 모든 매장 조회
	public List<StoreListDTO> listStoreList() {
		return storeListRepository.findAll();
	}
	
	// 필터링된 매장 조회(지역, 카테고리 기반)
//	public List<StoreListDTO> findByRegionAndCategory(Long regionId, Long categoryId) {
//	    // 가게 목록에서 필터링
//	    return storeListRepository.findByRegionIdAndCategoryId(regionId, categoryId);
//	}
	
	// 필터링된 매장 조회(지역, 카테고리 기반)
    public List<StoreListWithDetailsDTO> findByRegionAndCategory(Long regionId, Long categoryId) {
        // 가게 리스트 가져오기
        List<StoreListDTO> stores = storeListRepository.findByRegionIdAndCategoryId(regionId, categoryId);

        // 지역명 조회
        String regionName = regionRepository.findById(regionId)
            .map(region -> region.getZone() + ", " + region.getCity()) // 지역명 반환
            .orElse("Unknown Region");

        // 카테고리명 조회
        String categoryName = categoryRepository.findById(categoryId)
            .map(category -> category.getName())  // 카테고리명 반환
            .orElse("Unknown Category");

        // DTO 리스트 생성
        return stores.stream()
                .map(store -> new StoreListWithDetailsDTO(
                        store.getId(),
                        store.getStore(),
                        regionName,
                        categoryName))
                .collect(Collectors.toList());
    }
}