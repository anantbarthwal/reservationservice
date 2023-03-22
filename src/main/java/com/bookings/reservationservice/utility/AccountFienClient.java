package com.bookings.reservationservice.utility;

import com.bookings.reservationservice.models.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "AccountFeignClient", url = "http://localhost:8080/account")
public interface AccountFienClient {

    @GetMapping("/id/{id}")
    Account getAccountById(String id);

    @PostMapping("/create")
    Account createAccount(Account account);
}
