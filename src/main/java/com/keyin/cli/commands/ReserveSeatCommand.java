package com.keyin.cli.commands;

import com.keyin.cli.api.models.Flight;
import com.keyin.cli.api.models.Passenger;

public class ReserveSeatCommand {

    public void reserveSeat(Flight flight, Passenger passenger) {
        // Implement logic to reserve a seat for the passenger on the flight
        // This could involve making an HTTP POST request to the server endpoint provided by your teammates

        if (flight != null && passenger != null) {
            // Simplified example logic (pseudo-code)
            if (flight.getAircraft().getCapacity() > 0) {
                // Example of setting a seat (this would be more complex in a real implementation)
                flight.setSeat(0, 0, new Booking(1, flight.getFlightId(), passenger.getPassengerId(), 0, 0));
                System.out.println("Seat reserved successfully for passenger ID: " + passenger.getPassengerId());
            } else {
                System.out.println("No available seats on this flight.");
            }
        } else {
            System.out.println("Invalid flight or passenger information.");
        }
    }
}
