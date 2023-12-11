package com.anurag.SeatBookingService.service;

import com.anurag.SeatBookingService.model.booking_details;
import com.anurag.SeatBookingService.model.seat;
import com.anurag.SeatBookingService.model.user;
import com.anurag.SeatBookingService.repository.iBookingDetailsRepo;
import com.anurag.SeatBookingService.repository.iSeatRepo;
import com.anurag.SeatBookingService.repository.iUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    UserService userService;

    @Autowired
    SeatService seatService;

    @Autowired
    iSeatRepo seatRepo;

    @Autowired
    iBookingDetailsRepo bookingDetailsRepo;

    @Autowired
    iUserRepo userRepo;

    public String bookingSeats(Integer[] seatId, String phoneNumber, String name) {
        user user = userService.findUserByName(name);

        if(user == null)
            return "User does not exists";

        //Now check if seats to be booked are available or not

        for(Integer id : seatId)
        {
            if(!seatService.checkAvailability(id))
            {
                return "Seat number " + id + " is already booked";
            }
        }

        //Now up until here we know that all seats are available and user is also valid, so we will book seats

        booking_details booking_details = new booking_details();

        booking_details.setUser(user);

        //Now set the price of booking
        Double TotalPrice= 0.0;

        //Now get the prices for all classes
        for(Integer id : seatId)
        {
            seat seat = seatRepo.findById(id).orElse(null);

            assert seat != null;
            Double price = seatService.getPriceByClass(seat.getSclass());
            TotalPrice += price;

        }

        //Now set the price
        booking_details.setPrice(TotalPrice);

        //Now book the seats
        for(Integer id : seatId)
        {
            seatService.bookSeats(id);
        }

        //Now our seats are booked
        booking_details.setSeats(seatId);


        bookingDetailsRepo.save(booking_details);

        return "Your Booking Id is "+ booking_details.getId()  + " and total price is " + TotalPrice;
    }

    public List<booking_details> bookings(String userEmail, String phoneNumber) {
        //First we need to extract user
        user user =  userRepo.getByemail(userEmail);

        if(user == null)
        {
            user = userRepo.getByphonenumber(phoneNumber);
            if(user == null)
                return null;
        }

        return bookingDetailsRepo.findAllByuser(user);
    }
}
