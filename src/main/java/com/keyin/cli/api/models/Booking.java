package com.keyin.rest.booking;

public class Booking {
    private long booking_ID;
    private long flight_ID;
    private long passenger_ID;
    private int seatRow;
    private int seatColumn;

    public Booking(long booking_ID, long flight_ID, long passenger_ID, int seatRow, int seatColumn) {
        this.booking_ID = booking_ID;
        this.flight_ID = flight_ID;
        this.passenger_ID = passenger_ID;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
    }

    public long getBooking_ID() {
        return booking_ID;
    }

    public void setBooking_ID(long booking_ID) {
        this.booking_ID = booking_ID;
    }

    public long getFlight_ID() {
        return flight_ID;
    }

    public void setFlight_ID(long flight_ID) {
        this.flight_ID = flight_ID;
    }

    public long getPassenger_ID() {
        return passenger_ID;
    }

    public void setPassenger_ID(long passenger_ID) {
        this.passenger_ID = passenger_ID;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
    }
}
