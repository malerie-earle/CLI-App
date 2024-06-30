package com.keyin.cli.api.models;

public class SeatingChart {
    private long id;
    private long flightId;
    private int seatRow;
    private int seatColumn;
    private boolean isOccupied;
    private long passengerId;

    public SeatingChart() {}

    public SeatingChart(long id, long flightId, int seatRow, int seatColumn, boolean isOccupied, long passengerId) {
        this.id = id;
        this.flightId = flightId;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.isOccupied = isOccupied;
        this.passengerId = passengerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
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

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    @Override
    public String toString() {
        return "Seating Chart - " +
                "ID: " + id +
                ", Flight ID: " + flightId +
                ", Passenger ID: " + passengerId +
                ", Seat Row: " + seatRow +
                ", Seat Column: " + seatColumn +
                ", Occupied: " + isOccupied +
                '.';
    }
}
