package com.keyin.cli.menus;

import com.keyin.cli.commands.ReportMenuCommands;

import java.util.Scanner;

public class ReportMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportMenuCommands reportMenuCommands = new ReportMenuCommands(scanner);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    //reportMenuCommands.generateAirportReport();
                    break;
                case 2:
                    //reportMenuCommands.generateAircraftReport();
                    break;
                case 3:
                    //reportMenuCommands.generateFlightReport();
                    break;
                case 4:
                    //reportMenuCommands.generateBookingReport();
                    break;
                case 5:
                    //reportMenuCommands.generatePassengerReport();
                    break;
                case 6:
                    //reportMenuCommands.generateSeatingChartReport();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

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
