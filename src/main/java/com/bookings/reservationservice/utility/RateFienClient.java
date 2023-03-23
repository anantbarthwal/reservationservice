package com.bookings.reservationservice.utility;

import com.bookings.reservationservice.models.RateCreateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "rate-service", path = "/rates")
public interface RateFienClient {

    @PostMapping("/reservation/create")
    public Double calculateRateForReservation(@RequestBody RateCreateRequest rateCreateRequest);
}
