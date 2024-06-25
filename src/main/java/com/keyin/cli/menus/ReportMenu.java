package com.keyin.cli.menus;

import java.util.Scanner;

public class ReportMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    GenerateAirportReport();
                    break;
                case 2:
                    GenerateAircraftReport();
                    break;
                case 3:
                    GenerateFlightReport();
                    break;
                case 4:
                    GenerateBookingReport();
                    break;
                case 5:
                    GeneratePassengerReport();
                    break;
                case 6:
                    GenerateSeatingChartReport();
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
        System.out.println("===== Report Menu =====");
        System.out.println("1. Generate Airport Report");
        System.out.println("2. Generate Aircraft Report");
        System.out.println("3. Generate Flight Report");
        System.out.println("4. Generate Booking Report");
        System.out.println("5. Generate Passenger Report");
        System.out.println("6. Generate Seating Chart Report");
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

}
