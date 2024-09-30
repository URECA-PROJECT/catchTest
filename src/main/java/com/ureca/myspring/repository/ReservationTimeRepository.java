package com.ureca.myspring.repository;

import com.ureca.myspring.dto.ReservationTimeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ReservationTimeRepository extends JpaRepository<ReservationTimeDTO, Long> {
    List<ReservationTimeDTO> findByStoreIdAndYearAndMonthAndDay(Long storeId, int year, int month, int day);
}