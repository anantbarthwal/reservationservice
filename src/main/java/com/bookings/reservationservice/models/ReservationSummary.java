package com.bookings.reservationservice.models;

public class ReservationSummary {
    private String id;
    private String accountId;
    private String userId;
    private Double nightlyRoomCharge;
    private String roomTypeId;
    private String ratePlanId;
    private Integer numberOfNights;

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

    public Double getNightlyRoomCharge() {
        return nightlyRoomCharge;
    }

    public void setNightlyRoomCharge(Double nightlyRoomCharge) {
        this.nightlyRoomCharge = nightlyRoomCharge;
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
}
