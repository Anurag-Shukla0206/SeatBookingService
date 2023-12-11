package com.anurag.SeatBookingService.repository;

import com.anurag.SeatBookingService.model.booking_details;
import com.anurag.SeatBookingService.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iBookingDetailsRepo extends JpaRepository<booking_details, Integer> {
    List<booking_details> findAllByuser(user user);
}
