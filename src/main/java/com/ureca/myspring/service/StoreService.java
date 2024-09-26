package com.ureca.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ureca.myspring.dto.StoreDTO;
import com.ureca.myspring.repository.StoreRepository;

@Service
public class StoreService {
    
    @Autowired
    private StoreRepository storeRepository;

    public List<StoreDTO> getAllStores() {
        return storeRepository.findAll();
    }
    
    public StoreDTO getStoreById(Long storeId) {
        return storeRepository.findById(storeId).orElse(null); // ID로 조회, 없으면 null 반환
    }
    
    public StoreDTO getStoreByStoreListId(Long storeListId) {
        return storeRepository.findByStoreListId(storeListId);
    }
}