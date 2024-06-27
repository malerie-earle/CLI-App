package com.keyin.cli.commands;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ReportMenuCommands {
    private final Scanner scanner;
    private final APIClient apiClient;

    public ReportMenuCommands(Scanner scanner) {
        this.scanner = scanner;
        this.apiClient = new APIClient();
    }

    public void generateAirportReport() {
        try {
            System.out.println("Generating Airport Report...");
            List<Airport> airports = apiClient.getAllAirports();
            if (airports != null && !airports.isEmpty()) {
                for (Airport airport : airports) {
                    System.out.println(airport);
                }
            } else {
                System.out.println("No airports available.");
            }
        } catch (IOException e) {
            System.err.println("Error generating airport report: " + e.getMessage());
        }
    }

    public void generateAircraftReport() {
        try {
            System.out.println("Generating Aircraft Report...");
            List<Aircraft> aircrafts = apiClient.getAllAircrafts();
            if (aircrafts != null && !aircrafts.isEmpty()) {
                for (Aircraft aircraft : aircrafts) {
                    System.out.println(aircraft);
                }
            } else {
                System.out.println("No aircrafts available.");
            }
        } catch (IOException e) {
            System.err.println("Error generating aircraft report: " + e.getMessage());
        }
    }

    public void generateFlightReport() {
        try {
            System.out.println("Generating Flight Report...");
            List<Flight> flights = apiClient.getAllFlights();
            if (flights != null && !flights.isEmpty()) {
                for (Flight flight : flights) {
                    System.out.println(flight);
                }
            } else {
                System.out.println("No flights available.");
            }
        } catch (IOException e) {
            System.err.println("Error generating flight report: " + e.getMessage());
        }
    }

    public void generateBookingReport() {
        try {
            System.out.println("Generating Booking Report...");
            List<Booking> bookings = apiClient.getAllBookings();
            if (bookings != null && !bookings.isEmpty()) {
                for (Booking booking : bookings) {
                    System.out.println(booking);
                }
            } else {
                System.out.println("No bookings available.");
            }
        } catch (IOException e) {
            System.err.println("Error generating booking report: " + e.getMessage());
        }
    }

    public void generatePassengerReport() {
        try {
            System.out.println("Generating Passenger Report...");
            List<Passenger> passengers = apiClient.getAllPassengers();
            if (passengers != null && !passengers.isEmpty()) {
                for (Passenger passenger : passengers) {
                    System.out.println(passenger);
                }
            } else {
                System.out.println("No passengers available.");
            }
        } catch (IOException e) {
            System.err.println("Error generating passenger report: " + e.getMessage());
        }
    }

    public void generateSeatingChartReport() {
        try {
            System.out.println("Generating Seating Chart Report...");
            List<SeatingChart> seatingCharts = apiClient.getAllSeatingCharts();
            if (seatingCharts != null && !seatingCharts.isEmpty()) {
                for (SeatingChart seatingChart : seatingCharts) {
                    System.out.println(seatingChart);
                }
            } else {
                System.out.println("No seating charts available.");
            }
        } catch (IOException e) {
            System.err.println("Error generating seating chart report: " + e.getMessage());
        }
    }
}
