package com.bookings.reservationservice.repository;

import com.bookings.reservationservice.domains.ReservationDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<ReservationDomain, String> {
}
