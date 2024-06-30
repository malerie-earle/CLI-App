package com.keyin.cli.api.models;

import com.keyin.cli.api.models.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Flight {
    private long flight_ID;
    private Airport origin;
    private Airport destination;
    private Aircraft aircraft;
    private String departure_time;
    private String arrival_time;
    private Status status;
    private Booking[][] bookings;

    public Flight(){

    }

    public Flight(long flight_ID, Airport origin, Airport destination, Aircraft aircraft, String departure_time, String arrival_time, Status status) {
        this.flight_ID = flight_ID;
        this.origin = origin;
        this.destination = destination;
        this.aircraft = aircraft;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.status = status;
        this.bookings = new Booking[aircraft.getRows()][aircraft.getColumns()];
    }

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

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Booking[][] getBookings() {
        return bookings;
    }

    public void setBookings(Booking[][] bookings) {
        this.bookings = bookings;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long calcululateFlightDuration() {
        return LocalDateTime.parse(departure_time).until(LocalDateTime.parse(arrival_time), ChronoUnit.MINUTES);
    }

    public boolean isOccupied(int row, int col) {
        return bookings[row][col] != null;
    }

    public void setSeat(int row, int col, Booking booking) {
        bookings[row][col] = booking;
    }

    public enum Status {
        ON_TIME, DELAYED, CANCELED
    }

    public void displaySeatingChart(){
        for(Booking[] row : bookings){
            System.out.println();
            for (Booking col : row){
                if(col == null){
                    System.out.print("[ ] ");
                } else {
                    System.out.print("[0] ");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Flight - " +
                "ID: " + flight_ID +
                ", Origin Airport: " + origin +
                ", Destination Airport: " + destination +
                ", Aircraft: " + aircraft +
                ", Departure Date/Time: " + departure_time +
                ", Arrival Date/Time: " + arrival_time +
                ", Status: " + status +
                ", Bookings: " + bookings +
                '.';
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
