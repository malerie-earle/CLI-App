package com.keyin.cli.menus;

import java.util.Scanner;

public class PassengerMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    ViewAllPassengers();
                    break;
                case 2:
                    SearchPassengersMenu();
                    break;
                case 3:
                    AddPassenger();
                    break;
                case 4:
                    EditPassengerByID();
                    break;
                case 5:
                    DeletePassengerByID();
                    break;
                case 6:
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
        System.out.println("===== Passenger Management System =====");
        System.out.println("1. View All Passengers");
        System.out.println("2. Search Passengers Menu");
        System.out.println("3. Add Passenger");
        System.out.println("4. Edit Passenger by ID");
        System.out.println("5. Delete Passenger by ID");
        System.out.println("6. Exit");
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
