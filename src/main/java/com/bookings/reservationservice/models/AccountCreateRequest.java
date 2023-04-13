package com.bookings.reservationservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateRequest {
        private String roomTypeId;
        private Integer numberOfNights;
        private String ratePlanId;
}
