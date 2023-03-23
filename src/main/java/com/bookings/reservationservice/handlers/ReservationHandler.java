package com.bookings.reservationservice.handlers;

import com.bookings.reservationservice.domains.ReservationDomain;
import com.bookings.reservationservice.models.Account;
import com.bookings.reservationservice.models.RateCreateRequest;
import com.bookings.reservationservice.models.ReservationCreateRequest;
import com.bookings.reservationservice.models.ReservationSummary;
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
    public static final String CREATE_RATE_URL = "http://RATE-SERVICE/rates/reservation/create";
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
        HttpEntity<Account> request = new HttpEntity<Account>(new Account(), headers);
        ResponseEntity<Account> account = restTemplate.postForEntity(CREATE_ACCOUNT_URL, request, Account.class);
        String accountId = account.getBody().getId();

        /*String accountId = accountFienClient.createAccount(new Account()).getId();*/
        RateCreateRequest rateCreateRequest = new RateCreateRequest();
        rateCreateRequest.setNightlyRoomCharge(500.0);
        rateCreateRequest.setNumberOfNights(reservationCreateRequest.getNumberOfNights());
        rateCreateRequest.setRoomTypeId(reservationCreateRequest.getRoomType());
        /*Double rate = rateFienClient.calculateRateForReservation(rateCreateRequest);*/
        HttpEntity<RateCreateRequest> rateRequest = new HttpEntity<RateCreateRequest>(rateCreateRequest, headers);
        ResponseEntity<Double> rate = restTemplate.postForEntity(CREATE_RATE_URL, rateRequest, Double.class);
        ReservationDomain reservationDomain = new ReservationDomain(accountId, reservationCreateRequest.getUserId(),
                null, null, null, 2);
        return reservationRepository.save(reservationDomain).toModel();
    }
}
