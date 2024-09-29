package com.ureca.myspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ureca.myspring.dto.BookmarkDTO;
import com.ureca.myspring.dto.CategoryDTO;
import com.ureca.myspring.dto.StoreDTO;
import com.ureca.myspring.service.BookmarkService;
import com.ureca.myspring.service.CategoryService;

@RestController
@CrossOrigin(origins = "*") // 클라이언트의 주소
@RequestMapping("/bookmark") // 공통 경로
public class BookmarkController {
	@Autowired
	private BookmarkService bookmarkService;
	
	// 모든 카테고리 정보
    @GetMapping
    public List<BookmarkDTO> listBookmark() {        
        return bookmarkService.listBookmark();
    }
    
    @PostMapping
    public Map<String, Object> saveBookmark(@RequestBody BookmarkDTO bookmark) {
        bookmarkService.saveBookmark(bookmark);
        Map<String,Object> result = new HashMap<>();
        result.put("code","ok");
        return result;
    }
    
    @DeleteMapping
    public Map<String, Object> deleteBookmark(@RequestBody Map<String, Long> bookmarkData) {
        Long memberID = bookmarkData.get("memberID");
        Long storeID = bookmarkData.get("storeID");
        return bookmarkService.deleteBookmark(memberID, storeID);
    }
    

}
