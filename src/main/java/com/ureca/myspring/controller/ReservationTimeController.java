package com.ureca.myspring.controller;

import com.ureca.myspring.dto.ReservationTimeDTO;
import com.ureca.myspring.service.ReservationTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@CrossOrigin(origins = "*")
public class ReservationTimeController {

    @Autowired
    private ReservationTimeService reservationTimeService;

    // 특정 날짜의 예약된 시간대 가져오기
    @GetMapping("/{storeId}/{date}")
    public List<ReservationTimeDTO> getReservations(
            @PathVariable Long storeId,
            @PathVariable String date) {
        String[] dateParts = date.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);

        return reservationTimeService.getReservations(storeId, year, month, day);
    }

    // 새로운 예약 생성
    @PostMapping
    public ReservationTimeDTO createReservation(@RequestBody ReservationTimeDTO reservationTimeDTO) {
        return reservationTimeService.createReservation(reservationTimeDTO);
    }
}