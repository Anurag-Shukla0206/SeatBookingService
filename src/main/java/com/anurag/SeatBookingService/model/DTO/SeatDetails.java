package com.anurag.SeatBookingService.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatDetails {
    private com.anurag.SeatBookingService.model.seat seat;
    private Double seatPrice;

}