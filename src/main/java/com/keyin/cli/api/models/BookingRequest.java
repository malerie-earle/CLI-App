package com.keyin.cli.api.models;

public class BookingRequest {
    private long flightId;
    private long passengerId;

    public BookingRequest() {
    }

    public BookingRequest(long flightId, long passengerId) {
        this.flightId = flightId;
        this.passengerId = passengerId;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }
}
