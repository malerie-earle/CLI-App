package com.keyin.cli.api.models;

public class Passenger {
    private long passenger_ID;
    private String first_name;
    private String last_name;
    private String email;

    public Passenger(){

    }

    public Passenger(long passenger_ID, String first_name, String last_name, String email) {
        this.passenger_ID = passenger_ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    // Getters and Setters
    public long getPassenger_ID() {
        return passenger_ID;
    }

    public void setPassenger_ID(long passenger_ID) {
        this.passenger_ID = passenger_ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passenger_ID=" + passenger_ID +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
