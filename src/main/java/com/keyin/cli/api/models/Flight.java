package com.keyin.rest.flight; // Assuming this is the correct package

public class Flight {
    private String flightId;
    private String origin;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private int duration; // Duration in minutes
    private int seatsAvailable;

    // Constructors, getters, setters, toString, etc.

    // Example constructors
    public Flight() {
    }

    public Flight(String flightId, String origin, String destination, String departureTime, String arrivalTime, int duration, int seatsAvailable) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.seatsAvailable = seatsAvailable;
    }

    // Getters and Setters (only necessary getters are shown here)
    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    // Override toString() method to provide a meaningful representation of the object
    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", duration=" + duration +
                ", seatsAvailable=" + seatsAvailable +
                '}';
    }
}
