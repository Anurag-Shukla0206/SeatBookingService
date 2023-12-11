package com.anurag.SeatBookingService.repository;

import com.anurag.SeatBookingService.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUserRepo extends JpaRepository<user, Integer> {

    user findUserByname(String userName);


    user getByemail(String userEmail);

    user getByphonenumber(String phoneNumber);

}
