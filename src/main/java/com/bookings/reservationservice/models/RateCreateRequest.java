package com.bookings.reservationservice.models;

public class RateCreateRequest {
    private String roomTypeId;
    private Double nightlyRoomCharge;
    private Integer numberOfNights;

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Double getNightlyRoomCharge() {
        return nightlyRoomCharge;
    }

    public void setNightlyRoomCharge(Double nightlyRoomCharge) {
        this.nightlyRoomCharge = nightlyRoomCharge;
    }

    public Integer getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(Integer numberOfNights) {
        this.numberOfNights = numberOfNights;
    }
}
