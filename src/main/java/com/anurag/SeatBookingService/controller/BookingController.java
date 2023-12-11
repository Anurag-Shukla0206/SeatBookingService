package com.anurag.SeatBookingService.controller;

import com.anurag.SeatBookingService.model.DTO.SeatDetails;
import com.anurag.SeatBookingService.model.booking_details;
import com.anurag.SeatBookingService.model.seat;
import com.anurag.SeatBookingService.model.user;
import com.anurag.SeatBookingService.service.BookingService;
import com.anurag.SeatBookingService.service.SeatService;
import com.anurag.SeatBookingService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingService bookingService;

    @Autowired
    SeatService seatService;

    @Autowired
    UserService userService;

    //For registering as a user
    @PostMapping("POST/user")
    public String registerUser(@RequestBody user user)
    {
        return userService.registerUser(user);
    }

    //Get all seats
    @GetMapping("GET/seats")
    public List<seat> getSeats()
    {
        System.out.println("Working Directory: " + System.getProperty("user.dir"));

        return  seatService.getSeats();
    }

    //Get seat details with price by providing id

    @GetMapping("GET/seat/{ID}")
    public SeatDetails getSeatDetail(@PathVariable Integer ID)
    {
        return seatService.getSeat(ID);
    }

    //Book list of seats by providing name and phoneNumber of the user

    @PostMapping("POST/booking")
    public String bookingSeats(@RequestBody Integer [] seatId, String phoneNumber, String name)
    {
        return bookingService.bookingSeats(seatId, phoneNumber, name);
    }

    //Get bookings made by user

    @GetMapping("GET/bookings")
    public List<booking_details> bookings(@RequestParam String userEmail, @RequestParam String phoneNumber)
    {
        return bookingService.bookings(userEmail, phoneNumber);
    }
}
