package com.keyin.rest.passenger; // Assuming this is the correct package

public class Passenger {
    private long passengerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    // Constructors, getters, setters, toString, etc.

    // Example constructors
    public Passenger() {
    }

    public Passenger(long passengerId, String firstName, String lastName, String email, String phoneNumber) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters (only necessary getters are shown here)
    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Override toString() method to provide a meaningful representation of the object
    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
