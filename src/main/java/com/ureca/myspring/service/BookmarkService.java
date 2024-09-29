package com.ureca.myspring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ureca.myspring.dto.BookmarkDTO;
import com.ureca.myspring.dto.CategoryDTO;
import com.ureca.myspring.dto.StoreDTO;
import com.ureca.myspring.repository.BookmarkRepository;
import com.ureca.myspring.repository.CategoryRepository;
import com.ureca.myspring.repository.StoreRepository;

@Service
public class BookmarkService {
	@Autowired
	private BookmarkRepository bookmarkRepository ;

	public List<BookmarkDTO> listBookmark() {
		return bookmarkRepository.findAll();
	}

	public void saveBookmark(BookmarkDTO bookmark) {
		bookmarkRepository.save(bookmark);
		
	}
	
    public Map<String, Object> deleteBookmark(Long memberID, Long storeID) {
        BookmarkDTO bookmark = bookmarkRepository.findByMemberIDAndStoreID(memberID, storeID);
        Map<String, Object> result = new HashMap<>();
        if (bookmark != null) {
            bookmarkRepository.delete(bookmark);
            result.put("code", "deleted");
        } else {
            result.put("code", "not_found");
        }
        return result;
    }
    
}