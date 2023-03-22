package com.bookings.reservationservice.controllers;

import com.bookings.reservationservice.handlers.ReservationHandler;
import com.bookings.reservationservice.models.ReservationCreateRequest;
import com.bookings.reservationservice.models.ReservationSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationHandler reservationHandler;
    @PostMapping("/create")
    public ReservationSummary createReservation(@RequestBody ReservationCreateRequest reservationCreateRequest) {
        return reservationHandler.createReservation(reservationCreateRequest);
    }
}
