package com.anurag.SeatBookingService.repository;

import com.anurag.SeatBookingService.model.seat_price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iSeatPriceRepo extends JpaRepository<seat_price, Integer> {

    seat_price getBysclass(String seatClass);
}
