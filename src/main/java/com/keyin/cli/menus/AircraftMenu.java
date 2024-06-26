package com.keyin.cli.menus;

import com.keyin.cli.commands.*;
import com.keyin.cli.api.APIClient;

import java.util.Scanner;

public class AircraftMenu {
    private final APIClient apiClient;

    public AircraftMenu(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    new ListAircraftCommand(apiClient).execute();
                    break;
                case 2:
                    new SearchAircraftCommand(apiClient).execute();
                    break;
                case 3:
                    new AddAircraftCommand(apiClient).execute();
                    break;
                case 4:
                    new EditAircraftCommand(apiClient).execute();
                    break;
                case 5:
                    new DeleteAircraftCommand(apiClient).execute();
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
        System.out.println("===== Aircraft Management System =====");
        System.out.println("1. View All Aircraft");
        System.out.println("2. Search Aircraft Menu");
        System.out.println("3. Add Aircraft");
        System.out.println("4. Edit Aircraft by ID");
        System.out.println("5. Delete Aircraft by ID");
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
