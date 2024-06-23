package com.keyin.cli;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.Flight;
import com.keyin.cli.api.models.Passenger;
import com.keyin.cli.commands.BookFlightCommand;
import com.keyin.cli.commands.ListFlightsCommand;
import com.keyin.cli.commands.ReserveSeatCommand;
import com.keyin.cli.utils.InputReader;

import java.io.IOException;
import java.util.List;

public class FlightCLI {
    private static final APIClient apiClient = new APIClient();
    private static final InputReader inputReader = new InputReader();

    public static void main(String[] args) {
        System.out.println("Welcome to FlightCLI!");

        while (true) {
            printMenu();
            int choice = inputReader.readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    listFlights();
                    break;
                case 2:
                    bookFlight();
                    break;
                case 3:
                    reserveSeat();
                    break;
                case 4:
                    listPassengers();
                    break;
                case 5:
                    System.out.println("Exiting FlightCLI. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n### Menu ###");
        System.out.println("1. List all flights");
        System.out.println("2. Book a flight");
        System.out.println("3. Reserve a seat");
        System.out.println("4. List all passengers");
        System.out.println("5. Exit");
    }

    private static void listFlights() {
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

    private static void listPassengers() {
        try {
            List<Passenger> passengers = apiClient.getAllPassengers();
            if (passengers != null && !passengers.isEmpty()) {
                System.out.println("\n### Passengers ###");
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

    private static void bookFlight() {
        long flightId = inputReader.readLong("Enter flight ID: ");
        long passengerId = inputReader.readLong("Enter passenger ID: ");
        String seatClass = inputReader.readString("Enter seat class: ");
        try {
            String response = apiClient.bookFlight(flightId, passengerId, seatClass);
            System.out.println("Booking response: " + response);
        } catch (IOException e) {
            System.err.println("Error booking flight: " + e.getMessage());
        }
    }

    private static void reserveSeat() {
        // Implement reserveSeat logic if needed
        System.out.println("Reserve a seat functionality not implemented yet.");
    }
}
