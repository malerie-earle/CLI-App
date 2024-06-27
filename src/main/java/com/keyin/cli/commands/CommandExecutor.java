package com.keyin.cli.commands;

import com.keyin.cli.api.APIClient;
import java.util.Scanner;

public class CommandExecutor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        APIClient apiClient = new APIClient();
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    FlightMenuCommands flightMenuCommands = new FlightMenuCommands(apiClient, scanner);
                    handleFlightMenu(flightMenuCommands);
                    break;
                case 2:
                    PassengerMenuCommands passengerMenuCommands = new PassengerMenuCommands(apiClient, scanner);
                    handlePassengerMenu(passengerMenuCommands);
                    break;
                case 3:
                    ReportMenuCommands reportMenuCommands = new ReportMenuCommands(apiClient, scanner);
                    handleReportMenu(reportMenuCommands);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("===== Aerospace Operations Menu =====");
        System.out.println("1. Flight Management System");
        System.out.println("2. Passenger Management System");
        System.out.println("3. Report Management System");
        System.out.println("4. Exit");
        System.out.println();
        System.out.print("Select an option: ");
    }

    private static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            System.out.print("Select an option: ");
        }
        return scanner.nextInt();
    }

    private static void handleFlightMenu(FlightMenuCommands flightMenuCommands) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printFlightMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    flightMenuCommands.viewAllFlights();
                    break;
                case 2:
                    flightMenuCommands.searchFlightMenu();
                    break;
                case 3:
                    flightMenuCommands.addFlight();
                    break;
                case 4:
                    flightMenuCommands.editFlightById();
                    break;
                case 5:
                    flightMenuCommands.deleteFlightById();
                    break;
                // Remove seatingChartMenu if not needed
                case 6:
                    exit = true;
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void handlePassengerMenu(PassengerMenuCommands passengerMenuCommands) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printPassengerMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    passengerMenuCommands.viewAllPassengers();
                    break;
                case 2:
                    passengerMenuCommands.searchPassengersMenu();
                    break;
                case 3:
                    passengerMenuCommands.addPassenger();
                    break;
                case 4:
                    passengerMenuCommands.editPassengerById();
                    break;
                case 5:
                    passengerMenuCommands.deletePassengerById();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void handleReportMenu(ReportMenuCommands reportMenuCommands) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printReportMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    reportMenuCommands.generateAirportReport();
                    break;
                case 2:
                    reportMenuCommands.generateAircraftReport();
                    break;
                case 3:
                    reportMenuCommands.generateFlightReport();
                    break;
                case 4:
                    reportMenuCommands.generateBookingReport();
                    break;
                case 5:
                    reportMenuCommands.generatePassengerReport();
                    break;
                case 6:
                    reportMenuCommands.generateSeatingChartReport();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void printFlightMenu() {
        System.out.println();
        System.out.println("===== Flight Management System =====");
        System.out.println("1. View All Flights");
        System.out.println("2. Search Flights");
        System.out.println("3. Add Flight");
        System.out.println("4. Edit Flight by ID");
        System.out.println("5. Delete Flight by ID");
        System.out.println("6. Return to Main Menu");
        System.out.println();
        System.out.print("Select an option: ");
    }

    private static void printPassengerMenu() {
        System.out.println();
        System.out.println("===== Passenger Management System =====");
        System.out.println("1. View All Passengers");
        System.out.println("2. Search Passengers");
        System.out.println("3. Add Passenger");
        System.out.println("4. Edit Passenger by ID");
        System.out.println("5. Delete Passenger by ID");
        System.out.println("6. Return to Main Menu");
        System.out.println();
        System.out.print("Select an option: ");
    }

    private static void printReportMenu() {
        System.out.println();
        System.out.println("===== Report Management System =====");
        System.out.println("1. Generate Airport Report");
        System.out.println("2. Generate Aircraft Report");
        System.out.println("3. Generate Flight Report");
        System.out.println("4. Generate Booking Report");
        System.out.println("5. Generate Passenger Report");
        System.out.println("6. Generate Seating Chart Report");
        System.out.println("7. Return to Main Menu");
        System.out.println();
        System.out.print("Select an option: ");
    }
}
