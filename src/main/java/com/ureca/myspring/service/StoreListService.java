package com.ureca.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ureca.myspring.dto.StoreListDTO;
import com.ureca.myspring.repository.StoreListRepository;

@Service
public class StoreListService {
	@Autowired
	private StoreListRepository storeListRepository ;

	public List<StoreListDTO> listStoreList() {
		return storeListRepository.findAll();
	}
}
