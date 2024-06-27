package com.keyin.cli;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.menus.*;
import com.keyin.cli.util.InputReader;

public class FlightCLI {
    private static final APIClient apiClient = new APIClient();
    private static final InputReader inputReader = new InputReader();

    public static void main(String[] args) {
        System.out.println("Welcome to FlightCLI!");

        while (true) {
            printMainMenu();
            int choice = inputReader.readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    new FlightMenu(apiClient).display();
                    break;
                case 2:
                    new BookingMenu(apiClient).display();
                    break;
                case 3:
                    new PassengerMenu(apiClient).display();
                    break;
                case 4:
                    new AircraftMenu(apiClient).display();
                    break;
                case 5:
                    new AirportMenu(apiClient).display();
                    break;
                case 6:
                    new ReportMenu(apiClient).display();
                    break;
                case 7:
                    System.out.println("Exiting FlightCLI. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n### Main Menu ###");
        System.out.println("1. Flight Management");
        System.out.println("2. Booking Management");
        System.out.println("3. Passenger Management");
        System.out.println("4. Aircraft Management");
        System.out.println("5. Airport Management");
        System.out.println("6. Report Management");
        System.out.println("7. Exit");
    }
}
