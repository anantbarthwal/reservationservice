package com.bookings.reservationservice.domains;

import com.bookings.reservationservice.models.Account;
import com.bookings.reservationservice.models.ReservationSummary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "reservation")
public class ReservationDomain {
    @Id
    private String id;
    private String accountId;
    private String userId;
    private String roomTypeId;
    private String ratePlanId;
    private Integer numberOfNights;

    public ReservationDomain() {}

    public ReservationDomain(String accountId, String userId, String roomTypeId,
                             String ratePlanId, Integer numberOfNights) {
        this.accountId = accountId;
        this.userId = userId;
        this.roomTypeId = roomTypeId;
        this.ratePlanId = ratePlanId;
        this.numberOfNights = numberOfNights;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(String ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public Integer getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(Integer numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public ReservationSummary toModel() {
        ReservationSummary reservationSummary = new ReservationSummary();
        reservationSummary.setId(id);
        reservationSummary.setAccountId(accountId);
        reservationSummary.setUserId(userId);
        reservationSummary.setRatePlanId(ratePlanId);
        reservationSummary.setRoomTypeId(roomTypeId);
        reservationSummary.setNumberOfNights(numberOfNights);
        return reservationSummary;
    }
}
