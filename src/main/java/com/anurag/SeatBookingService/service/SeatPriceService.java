package com.anurag.SeatBookingService.service;

import com.anurag.SeatBookingService.model.seat_price;
import com.anurag.SeatBookingService.repository.iSeatPriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatPriceService {

    @Autowired
    iSeatPriceRepo seatPriceRepo;

    public void importData(List<seat_price> data) {
        seatPriceRepo.saveAll(data);
    }

}
