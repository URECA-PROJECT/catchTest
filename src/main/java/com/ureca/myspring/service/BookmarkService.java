package com.ureca.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ureca.myspring.dto.BookmarkDTO;
import com.ureca.myspring.dto.CategoryDTO;
import com.ureca.myspring.repository.BookmarkRepository;
import com.ureca.myspring.repository.CategoryRepository;

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
}