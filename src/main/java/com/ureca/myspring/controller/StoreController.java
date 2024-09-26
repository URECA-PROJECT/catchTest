package com.ureca.myspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ureca.myspring.dto.StoreDTO;
import com.ureca.myspring.service.StoreService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/store") 
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<StoreDTO> getAllStores() {
        return storeService.getAllStores();
    }
    
    @GetMapping("/{storeListId}")
    public StoreDTO getStoreByStoreListId(@PathVariable("storeListId") Long storeListId) {
        return storeService.getStoreByStoreListId(storeListId);
    }

}