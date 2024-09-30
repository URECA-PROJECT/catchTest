package com.ureca.myspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ureca.myspring.dto.MemberDTO;
import com.ureca.myspring.dto.StoreDTO;
import com.ureca.myspring.repository.StoreRepository;

import jakarta.persistence.EntityNotFoundException;

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

//	public void saveOrUpdateStore(StoreDTO storeDTO) {
//		// storeListId로 매장을 찾음
//        StoreDTO existingStore = storeRepository.findByStoreListId(storeDTO.getStoreListId());
//        
//        if (existingStore == null) {
//            // 매장이 존재하지 않으면 새로운 매장 정보 저장
//            saveStore(storeDTO);
//        } else {
//            // 매장이 존재하면 기존 매장을 업데이트
//            updateStore(storeDTO);
//        }
//		
//	}
//
//	private void updateStore(StoreDTO updatedStore) {
//		// 기존 회원 정보 조회
//        StoreDTO existingStore = storeRepository.findByStoreListId(updatedStore.getStoreListId());
//        
//        if (existingStore != null) {
//            existingStore.setAddress(updatedStore.getAddress());
//            existingStore.setContent(updatedStore.getContent());
//            existingStore.setCloseDay(updatedStore.getCloseDay());
//            existingStore.setOpenTime(updatedStore.getOpenTime());
//            existingStore.setCloseTime(updatedStore.getCloseTime());
//            existingStore.setImage(updatedStore.getImage());
//            
//            storeRepository.save(existingStore);
//        }		
//	}

	private StoreDTO saveStore(StoreDTO storeDTO) {
		StoreDTO store = new StoreDTO();
        store.setStore(storeDTO.getStore());
        store.setAddress(storeDTO.getAddress());
        store.setCloseDay(storeDTO.getCloseDay());
        store.setOpenTime(storeDTO.getOpenTime());
        store.setCloseTime(storeDTO.getCloseTime());
        store.setStoreListId(storeDTO.getStoreListId());
        store.setContent(storeDTO.getContent());
        store.setProfileImage(storeDTO.getProfileImage());
        
        return storeRepository.save(store);		
	}

	public StoreDTO saveOrUpdateStore(StoreDTO storeDTO) {
	    // storeListId로 매장을 찾음
	    StoreDTO existingStore = storeRepository.findByStoreListId(storeDTO.getStoreListId());

	    if (existingStore == null) {
	        // 매장이 존재하지 않으면 새로운 매장 정보 저장
	        return saveStore(storeDTO); // 새로운 매장을 저장하고 그 값을 반환
	    } else {
	        // 매장이 존재하면 기존 매장을 업데이트
	        existingStore.setAddress(storeDTO.getAddress());
	        existingStore.setCloseDay(storeDTO.getCloseDay());
	        existingStore.setOpenTime(storeDTO.getOpenTime());
	        existingStore.setCloseTime(storeDTO.getCloseTime());
	        existingStore.setStoreListId(storeDTO.getStoreListId());
	        existingStore.setContent(storeDTO.getContent());
	        existingStore.setProfileImage(storeDTO.getProfileImage()); // 프로필 이미지도 업데이트

	        // 업데이트된 매장 정보 저장 후 반환
	        return storeRepository.save(existingStore);
	    }
	}


}