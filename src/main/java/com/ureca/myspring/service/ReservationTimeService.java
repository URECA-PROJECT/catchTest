package com.ureca.myspring.service;

import com.ureca.myspring.dto.ReservationTimeDTO;
import com.ureca.myspring.repository.ReservationTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationTimeService {

    @Autowired
    private ReservationTimeRepository reservationTimeRepository;

    // 예약된 시간대 가져오기
    public List<ReservationTimeDTO> getReservations(Long storeId, int year, int month, int day) {
        return reservationTimeRepository.findByStoreIdAndYearAndMonthAndDay(storeId, year, month, day);
    }

    // 새로운 예약 저장
    public ReservationTimeDTO createReservation(ReservationTimeDTO reservationTimeDTO) {
        return reservationTimeRepository.save(reservationTimeDTO);
    }
}