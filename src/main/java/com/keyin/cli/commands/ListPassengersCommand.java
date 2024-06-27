package com.keyin.cli.commands;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.Passenger;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ListPassengersCommand {
    private final APIClient apiClient;
    private final Scanner scanner;

    public ListPassengersCommand(APIClient apiClient, Scanner scanner) {
        this.apiClient = apiClient;
        this.scanner = scanner;
    }

    public void execute() {
        try {
            System.out.println("Viewing all passengers...");
            List<Passenger> passengers = apiClient.getAllPassengers();
            if (passengers != null && !passengers.isEmpty()) {
                for (Passenger passenger : passengers) {
                    System.out.println(passenger);
                }
            } else {
                System.out.println("No passengers available.");
            }
        } catch (IOException e) {
            System.err.println("Error fetching passengers: " + e.getMessage());
        }
    }
}

