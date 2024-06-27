package com.keyin.cli.commands;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ReportMenuCommands {
    private final APIClient apiClient;
    private final Scanner scanner;

    public ReportMenuCommands(APIClient apiClient, Scanner scanner) {
        this.apiClient = apiClient;
        this.scanner = scanner;
    }

    public void generateAirportReport() {
        try {
            List<Airport> airports = apiClient.getAllAirports();
            if (airports != null && !airports.isEmpty()) {
                System.out.println("\nGenerating Airport Report:");
                for (Airport airport : airports) {
                    System.out.println("Name: " + airport.getName() + ", Code: " + airport.getCode());
                }
            } else {
                System.out.println("No airports found.");
            }
        } catch (IOException e) {
            System.err.println("Error generating airport report: " + e.getMessage());
        }
    }

    public void generateAircraftReport() {
        try {
            List<Aircraft> aircrafts = apiClient.getAllAircrafts();
            if (aircrafts != null && !aircrafts.isEmpty()) {
                System.out.println("\nGenerating Aircraft Report:");
                for (Aircraft aircraft : aircrafts) {
                    System.out.println("Registration Number: " + aircraft.getRegistrationNumber() + ", Model: " + aircraft.getModel());
                }
            } else {
                System.out.println("No aircrafts found.");
            }
        } catch (IOException e) {
            System.err.println("Error generating aircraft report: " + e.getMessage());
        }
    }

    public void generateFlightReport() {
        try {
            List<Flight> flights = apiClient.getAllFlights();
            if (flights != null && !flights.isEmpty()) {
                System.out.println("\nGenerating Flight Report:");
                for (Flight flight : flights) {
                    System.out.println("Flight Number: " + flight.getFlightNumber() + ", From: " + flight.getDepartureAirport() + ", To: " + flight.getDestinationAirport());
                }
            } else {
                System.out.println("No flights found.");
            }
        } catch (IOException e) {
            System.err.println("Error generating flight report: " + e.getMessage());
        }
    }

    public void generateBookingReport() {
        try {
            List<Booking> bookings = apiClient.getAllBookings();
            if (bookings != null && !bookings.isEmpty()) {
                System.out.println("\nGenerating Booking Report:");
                for (Booking booking : bookings) {
                    System.out.println("Booking ID: " + booking.getId() + ", Flight ID: " + booking.getFlightId() + ", Passenger ID: " + booking.getPassengerId());
                }
            } else {
                System.out.println("No bookings found.");
            }
        } catch (IOException e) {
            System.err.println("Error generating booking report: " + e.getMessage());
        }
    }

    public void generatePassengerReport() {
        try {
            List<Passenger> passengers = apiClient.getAllPassengers();
            if (passengers != null && !passengers.isEmpty()) {
                System.out.println("\nGenerating Passenger Report:");
                for (Passenger passenger : passengers) {
                    System.out.println("Name: " + passenger.getName() + ", Email: " + passenger.getEmail());
                }
            } else {
                System.out.println("No passengers found.");
            }
        } catch (IOException e) {
            System.err.println("Error generating passenger report: " + e.getMessage());
        }
    }

    public void generateSeatingChartReport() {
        try {
            List<SeatingChart> seatingCharts = apiClient.getAllSeatingCharts();
            if (seatingCharts != null && !seatingCharts.isEmpty()) {
                System.out.println("\nGenerating Seating Chart Report:");
                for (SeatingChart seatingChart : seatingCharts) {
                    System.out.println("Seating Chart for Flight ID: " + seatingChart.getFlightId());
                    // Assuming SeatingChart has a method to get seating details
                    System.out.println("Seating Details: " + seatingChart.getSeatingDetails());
                }
            } else {
                System.out.println("No seating charts found.");
            }
        } catch (IOException e) {
            System.err.println("Error generating seating chart report: " + e.getMessage());
        }
    }
}
