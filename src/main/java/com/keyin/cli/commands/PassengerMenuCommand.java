package com.keyin.cli.commands;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.Passenger;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PassengerMenuCommands {
    private final APIClient apiClient;
    private final Scanner scanner;

    public PassengerMenuCommands(APIClient apiClient, Scanner scanner) {
        this.apiClient = apiClient;
        this.scanner = scanner;
    }

    public void viewAllPassengers() {
        try {
            List<Passenger> passengers = apiClient.getAllPassengers();
            if (passengers != null && !passengers.isEmpty()) {
                System.out.println("\nListing all passengers:");
                for (Passenger passenger : passengers) {
                    System.out.println(passenger);
                }
            } else {
                System.out.println("No passengers found.");
            }
        } catch (IOException e) {
            System.err.println("Error fetching passengers: " + e.getMessage());
        }
    }

    public void searchPassengersMenu() {
        System.out.println("Enter search criteria to find passengers:");
        String searchCriteria = scanner.nextLine();
        // Implement search functionality
    }

    public void addPassenger() {
        System.out.println("Enter details to add a new passenger:");
        // Implement adding a new passenger
    }

    public void editPassengerById() {
        System.out.println("Enter passenger ID to edit:");
        // Implement editing passenger details
    }

    public void deletePassengerById() {
        System.out.println("Enter passenger ID to delete:");
        // Implement deleting a passenger
    }
}
