package com.keyin.cli.commands;

import com.keyin.cli.Command;
import com.keyin.cli.api.APIClient;
import java.io.IOException;

public class BookFlightCommand implements Command {
    private final APIClient apiClient;

    public BookFlightCommand(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public void execute() {
        long flightId = InputReader.readInt("Enter flight ID: ");
        long passengerId = InputReader.readInt("Enter passenger ID: ");
        try {
            String response = apiClient.bookFlight(flightId, passengerId);
            System.out.println("Booking response: " + response);
        } catch (IOException e) {
            System.err.println("Error booking flight: " + e.getMessage());
        }
    }

    @Override
    public String getCommandName() {
        return "Book a flight";
    }
}
