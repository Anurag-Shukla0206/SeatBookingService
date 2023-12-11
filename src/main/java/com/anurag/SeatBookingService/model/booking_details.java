package com.anurag.SeatBookingService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class booking_details {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double price;

    private Integer[] seats;

    @ManyToOne
    @JoinColumn(name = "user_fk_id")
    @JsonIgnore
    com.anurag.SeatBookingService.model.user user;







}
