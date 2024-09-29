package com.ureca.myspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ureca.myspring.dto.BookmarkDTO;
import com.ureca.myspring.dto.CategoryDetailDTO;

@Repository
public interface BookmarkRepository extends JpaRepository<BookmarkDTO, Long> {
    List<BookmarkDTO> findByMemberID(Long memberID);
}