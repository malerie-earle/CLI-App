package com.keyin.cli.commands;

import com.keyin.cli.Command;
import com.keyin.cli.api.APIClient;
import com.keyin.cli.utils.InputReader;
import java.util.Scanner;

import java.io.IOException;

public class BookFlightCommand implements Command {
    private final APIClient apiClient;

    public BookFlightCommand(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter flight ID:");
            long flightId = scanner.nextLong();
            System.out.println("Enter passenger ID: ");
            long passengerId = scanner.nextLong();
            System.out.println("Enter number of rows");
            int row = scanner.nextInt();
            System.out.println("Enter number of columns:");
            int col = scanner.nextInt();
            //Need changes here
            apiClient.bookFlight(flightId, passengerId, row, col);

        } catch (IOException e) {
            System.err.println("Error booking flight: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Please enter valid IDs.");
        }
    }

    @Override
    public String getCommandName() {
        return "Book a flight";
    }
}
