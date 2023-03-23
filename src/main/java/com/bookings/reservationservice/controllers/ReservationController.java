package com.bookings.reservationservice.controllers;

import com.bookings.reservationservice.handlers.ReservationHandler;
import com.bookings.reservationservice.models.ReservationCreateRequest;
import com.bookings.reservationservice.models.ReservationSummary;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationHandler reservationHandler;
    @PostMapping("/create")
    @CircuitBreaker(name= "accountRateBreaker", fallbackMethod = "accountRateFallBack")
    public ReservationSummary createReservation(@RequestBody ReservationCreateRequest reservationCreateRequest) {
        return reservationHandler.createReservation(reservationCreateRequest);
    }

    // creating accountRateFallBack method for circuitBreaker
    public ReservationSummary accountRateFallBack(ReservationCreateRequest reservationCreateRequest, Exception ex) {
        ReservationSummary reservationSummary = new ReservationSummary();
        reservationSummary.setUserId("this is fallback method");
        return reservationSummary;
    }
}
