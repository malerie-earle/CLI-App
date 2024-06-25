package com.keyin.cli.api.models;

import com.keyin.rest.airport.Airport;
import com.keyin.rest.aircraft.Aircraft;
import com.keyin.rest.booking.Booking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Flight {
    private long flight_ID;
    private Airport origin;
    private Airport destination;
    private Aircraft aircraft;
    private LocalDateTime departure_time;
    private LocalDateTime arrival_time;
    private Status status; // Enum or string
    private Booking[][] flightBookings;

    public Flight(long flight_ID, Airport origin, Airport destination, Aircraft aircraft, LocalDateTime departure_time, LocalDateTime arrival_time, Status status) {
        this.flight_ID = flight_ID;
        this.origin = origin;
        this.destination = destination;
        this.aircraft = aircraft;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.status = status;
        this.flightBookings = new Booking[aircraft.getRows()][aircraft.getColumns()];
    }

    // Getters and Setters
    public long getFlight_ID() {
        return flight_ID;
    }

    public void setFlight_ID(long flight_ID) {
        this.flight_ID = flight_ID;
    }


    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public LocalDateTime getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(LocalDateTime departure_time) {
        this.departure_time = departure_time;
    }

    public LocalDateTime getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(LocalDateTime arrival_time) {
        this.arrival_time = arrival_time;
    }

    public void setBookings(Booking[][] bookings) {
        this.flightBookings = bookings;
    }

    public Booking[][] getBookings() {
        return flightBookings;
    }

    public Long getFlightDuration(){
        return departure_time.until(arrival_time, ChronoUnit.MINUTES);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Enum for flight status
    public enum Status {
        ON_TIME, DELAYED, CANCELED
    }

    public boolean isOccupied(int row, int col){
        return flightBookings[row][col] != null;
    }

    public void setSeat(int row, int col, Booking booking){
        flightBookings[row][col] = booking;
    }

    /* TO DO
    public void assignRandomSeat() {
        Random random = new Random();
        while (true) {
            int row = random.nextInt(aircraft.getRows());
            int col = random.nextInt(aircraft.getColumns());
            if (!seatOccupied[row][col]) {
                seatOccupied[row][col] = true;
                break;
            }
        }
    }
     */
}