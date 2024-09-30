package com.ureca.myspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.ureca.myspring.dto.MemberDTO;
import com.ureca.myspring.dto.StoreDTO;
import com.ureca.myspring.service.FileStorageService;
import com.ureca.myspring.service.StoreService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/store") 
public class StoreController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private FileStorageService fileStorageService;
   
    @GetMapping
    public List<StoreDTO> getAllStores() {
        return storeService.getAllStores();
    }
    
    @GetMapping("/{storeListId}")
    public StoreDTO getStoreByStoreListId(@PathVariable("storeListId") Long storeListId) {
        return storeService.getStoreByStoreListId(storeListId);
    }
    
//    @PostMapping("/saveOrUpdate")
//    public Map<String, Object> saveOrUpdateStore(@RequestBody StoreDTO store) {
//        Map<String, Object> result = new HashMap<>();
//        storeService.saveOrUpdateStore(store);
//        result.put("code", "ok");
//        return result;
//    }
    
    // 회원 정보 수정 
    @PostMapping("/saveOrUpdate")
    public Map<String, Object> saveOrUpdateStore(
            @RequestPart("store") StoreDTO store, 
            @RequestPart(value = "profileImage", required = false) String profileImage) {
        
        // 이미지 처리
        if (profileImage != null && !profileImage.isEmpty()) {
            // 파일 저장
            String filePath = fileStorageService.storeBase64Image(profileImage);  // Base64 인코딩된 이미지 처리
            store.setProfileImage(filePath);  // 경로를 DTO의 profileImage 필드에 저장
        }
        
        // 멤버 정보 업데이트
        StoreDTO updatedStore = storeService.saveOrUpdateStore(store);
        
        Map<String, Object> result = new HashMap<>();
        result.put("code", "ok");
        result.put("updatedStore", updatedStore); // 수정된 멤버 정보 추가
        return result;
    }

}