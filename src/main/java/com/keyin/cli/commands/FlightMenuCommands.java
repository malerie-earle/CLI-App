package com.keyin.cli.commands;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.Flight;
import com.keyin.cli.menus.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FlightMenuCommands {

    private final APIClient apiClient;
    private final Scanner scanner;

    public FlightMenuCommands(APIClient apiClient, Scanner scanner) {
        this.apiClient = apiClient;
        this.scanner = scanner;
    }

    public void viewAllFlights() {
        try {
            List<Flight> flights = apiClient.getAllFlights();
            if (flights != null && !flights.isEmpty()) {
                System.out.println("\nListing all available flights:");
                for (Flight flight : flights) {
                    System.out.println(flight);
                }
            } else {
                System.out.println("No flights found.");
            }
        } catch (IOException e) {
            System.err.println("Error fetching flights: " + e.getMessage());
        }
    }

    public void searchFlightMenu() {
        System.out.println("Enter search criteria to find flights:");
        String searchCriteria = scanner.nextLine();
        try {
            //List<Flight> searchResults = apiClient.searchFlights(searchCriteria);
            List<Flight> searchResults = null;
            if (searchResults != null && !searchResults.isEmpty()) {
                System.out.println("\nSearch results for '" + searchCriteria + "':");
                for (Flight flight : searchResults) {
                    System.out.println(flight);
                }
            } else {
                System.out.println("No flights found matching the criteria.");
            }
        } catch (Exception e) {
            System.err.println("Error searching flights: " + e.getMessage());
        }
    }

    public void addFlight() {
        System.out.println("Enter details to add a new flight:");
        // Example: Read input for flight details from user
        String flightDetails = scanner.nextLine();
        try {
            Flight newFlight = null;
            System.out.println("New flight added successfully:");
            System.out.println(newFlight);
        } catch (Exception e) {
            System.err.println("Error adding new flight: " + e.getMessage());
        }
    }

    public void editFlightById() {
        System.out.println("Enter flight ID to edit its details:");
        long flightId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter updated details for flight:");
        String updatedDetails = scanner.nextLine();
        try {
            Flight updatedFlight = null;
            System.out.println("Flight with ID " + flightId + " updated successfully:");
            System.out.println(updatedFlight);
        } catch (Exception e) {
            System.err.println("Error updating flight: " + e.getMessage());
        }
    }

    public void deleteFlightById() {
        System.out.println("Enter flight ID to delete:");
        long flightId = Long.parseLong(scanner.nextLine());
        try {
            //apiClient.deleteFlight(flightId);
            System.out.println("Flight with ID " + flightId + " deleted successfully.");
        } catch (Exception e) {
            System.err.println("Error deleting flight: " + e.getMessage());
        }
    }
    /*
    public void seatingChartMenu() {
        System.out.println("Opening seating chart menu...");
        SeatingChartMenu seatingChartMenu = new SeatingChartMenu(apiClient, scanner);
        seatingChartMenu.main(new String[]{});
    }

     */
}
