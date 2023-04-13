package com.bookings.reservationservice.models;

public class ReservationCreateRequest {
    private String userId;
    private String ratePlanId;
    private String roomTypeId;
    private Integer numberOfNights;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(String ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Integer getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(Integer numberOfNights) {
        this.numberOfNights = numberOfNights;
    }
}
