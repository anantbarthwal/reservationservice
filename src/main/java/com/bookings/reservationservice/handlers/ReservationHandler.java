package com.bookings.reservationservice.handlers;

import com.bookings.reservationservice.domains.ReservationDomain;
import com.bookings.reservationservice.models.*;
import com.bookings.reservationservice.repository.ReservationRepository;
import com.bookings.reservationservice.utility.AccountFienClient;
import com.bookings.reservationservice.utility.RateFienClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationHandler {
    public static final String CREATE_ACCOUNT_URL = "http://ACCOUNT-SERVICE/account/create";
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private AccountFienClient accountFienClient;

    @Autowired
    private RateFienClient rateFienClient;

    @Autowired
    private RestTemplate restTemplate;
    public ReservationSummary createReservation(ReservationCreateRequest reservationCreateRequest) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        AccountCreateRequest accountCreateRequest = new AccountCreateRequest();
        accountCreateRequest.setRatePlanId(reservationCreateRequest.getRatePlanId());
        accountCreateRequest.setNumberOfNights(reservationCreateRequest.getNumberOfNights());
        accountCreateRequest.setRoomTypeId(reservationCreateRequest.getRoomTypeId());
        HttpEntity<AccountCreateRequest> request = new HttpEntity<AccountCreateRequest>(accountCreateRequest, headers);
        ResponseEntity<Account> account = restTemplate.postForEntity(CREATE_ACCOUNT_URL, request, Account.class);
        String accountId = account.getBody().getId();
        if(accountId == null) {
            throw new RuntimeException("service down");
        }
        ReservationDomain reservationDomain = new ReservationDomain(accountId, reservationCreateRequest.getUserId(),
                reservationCreateRequest.getRoomTypeId(), reservationCreateRequest.getRatePlanId(), 2);
        return reservationRepository.save(reservationDomain).toModel();
    }
}
