package com.keyin.cli.commands;

import com.keyin.cli.api.models.Flight;
import com.keyin.cli.api.models.Passenger;
import com.keyin.cli.api.APIClient;

import java.io.IOException;

public class ReserveSeatCommand {

    private final APIClient apiClient;

    public ReserveSeatCommand(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    public void reserveSeat(Flight flight, Passenger passenger) {
        if (flight != null && passenger != null) {
            try {
                //String response = apiClient.bookFlight(flight.getFlightId(), passenger.getPassengerId());
                String response = "toDo";
                //System.out.println("Seat reserved successfully for passenger ID: " + passenger.getPassengerId());
                System.out.println("Booking response: " + response);
            } catch (Exception e) {
                System.err.println("Error reserving seat: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid flight or passenger information.");
        }
    }
}
