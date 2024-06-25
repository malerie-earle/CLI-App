package com.keyin.cli.commands;

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
                    System.out.println(flight);
                }
            } else {
                System.out.println("No flights available.");
            }
        } catch (IOException e) {
            System.err.println("Error fetching flights: " + e.getMessage());
        }
    }

    @Override
    public String getCommandName() {
        return "List all flights";
    }
}
