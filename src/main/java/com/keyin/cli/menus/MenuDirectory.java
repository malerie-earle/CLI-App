package com.keyin.cli.menus;

import java.util.Scanner;

public class MenuDirectory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    FlightMenu();
                    break;
                case 2:
                    BookingMenu();
                    break;
                case 3:
                    PassengerMenu();
                    break;
                case 4:
                    AircraftMenu();
                    break;
                case 5:
                    AirportMenu();
                    break;
                case 6:
                    ReportMenu();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("===== Aerospace Operations =====");
        System.out.println("1. Flight Management System");
        System.out.println("2. Booking Management System");
        System.out.println("3. Passenger Management System");
        System.out.println("4. Aircraft Management System");
        System.out.println("5. Airport Management System");
        System.out.println("6. Report Management System");
        System.out.println("7. Exit");
        System.out.println();
        System.out.print("Choose an option: ");
    }

    private static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            System.out.print("Choose an option: ");
        }
        return scanner.nextInt();
    }

    private static void FlightMenu() {
        System.out.println("Flight Management System");
        FlightMenu();
    }

    private static void optionTwo() {
        System.out.println("You chose Option 2");
        // Add functionality for Option 2
    }

    private static void optionThree() {
        System.out.println("You chose Option 3");
        // Add functionality for Option 3
    }
}

