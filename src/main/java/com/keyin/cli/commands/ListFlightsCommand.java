package com.keyin.cli.commands;

import com.keyin.cli.Command;
import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.Flight;

import java.io.IOException;
import java.util.List;

public class ListFlightsCommand implements Command {
    private final APIClient apiClient;

    public ListFlightsCommand(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public void execute() {
        try {
            List<Flight> flights = apiClient.getAllFlights();
            if (flights != null && !flights.isEmpty()) {
                System.out.println("\n### Flights ###");
                for (Flight flight : flights) {
                    printFlightDetails(flight);
                }
            } else {
                System.out.println("No flights available.");
            }
        } catch (IOException e) {
            System.err.println("Error fetching flights: " + e.getMessage());
        }
    }

    private void printFlightDetails(Flight flight) {
        System.out.println("Flight ID: " + flight.getFlight_ID());
        System.out.println("Origin: " + flight.getOrigin().getName() + " (" + flight.getOrigin().getCode() + ")");
        System.out.println("Destination: " + flight.getDestination().getName() + " (" + flight.getDestination().getCode() + ")");
        System.out.println("Aircraft: " + flight.getAircraft().getModel() + " (" + flight.getAircraft().getAirline() + ")");
        System.out.println("Departure Time: " + flight.getDeparture_time());
        System.out.println("Arrival Time: " + flight.getArrival_time());
        System.out.println("Status: " + flight.getStatus());
        System.out.println("-----------------------------------------");
    }

    @Override
    public String getCommandName() {
        return "List all flights";
    }
}
