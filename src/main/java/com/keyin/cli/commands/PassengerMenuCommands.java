package com.keyin.cli.commands;

import java.io.IOException;
import java.util.Scanner;
import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.Passenger;

public class PassengerMenuCommands {
    private final Scanner scanner;
    private final APIClient apiClient;

    public PassengerMenuCommands(Scanner scanner) {
        this.scanner = scanner;
        this.apiClient = new APIClient();
    }

    public void viewAllPassengers() {
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

    public void searchPassengersMenu() {
        System.out.print("Enter passenger name to search: ");
        String name = scanner.next();
        try {
            System.out.println("Searching passengers...");
            List<Passenger> passengers = apiClient.searchPassengers(name);
            if (passengers != null && !passengers.isEmpty()) {
                for (Passenger passenger : passengers) {
                    System.out.println(passenger);
                }
            } else {
                System.out.println("No passengers found.");
            }
        } catch (IOException e) {
            System.err.println("Error searching passengers: " + e.getMessage());
        }
    }

    public void addPassenger() {
        System.out.print("Enter passenger name: ");
        String name = scanner.next();
        // Additional passenger details can be gathered here
        try {
            System.out.println("Adding passenger...");
            Passenger passenger = new Passenger(name); // Assume constructor and fields exist
            apiClient.addPassenger(passenger);
            System.out.println("Passenger added successfully.");
        } catch (IOException e) {
            System.err.println("Error adding passenger: " + e.getMessage());
        }
    }

    public void editPassengerById() {
        System.out.print("Enter passenger ID to edit: ");
        long id = scanner.nextLong();
        System.out.print("Enter new passenger name: ");
        String name = scanner.next();
        // Additional edits can be gathered here
        try {
            System.out.println("Editing passenger...");
            Passenger passenger = new Passenger(id, name); // Assume constructor and fields exist
            apiClient.editPassenger(passenger);
            System.out.println("Passenger edited successfully.");
        } catch (IOException e) {
            System.err.println("Error editing passenger: " + e.getMessage());
        }
    }

    public void deletePassengerById() {
        System.out.print("Enter passenger ID to delete: ");
        long id = scanner.nextLong();
        try {
            System.out.println("Deleting passenger...");
            apiClient.deletePassenger(id);
            System.out.println("Passenger deleted successfully.");
        } catch (IOException e) {
            System.err.println("Error deleting passenger: " + e.getMessage());
        }
    }
}
