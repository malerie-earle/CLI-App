package com.keyin.cli.menus;

import com.keyin.cli.commands.airport.*;
import java.util.Scanner;

public class AirportMenu {

    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    new ViewAllAirportsCommand().execute();
                    break;
                case 2:
                    new SearchAirportByIDCommand().execute();
                    break;
                case 3:
                    new AddAirportCommand().execute();
                    break;
                case 4:
                    new EditAirportByIDCommand().execute();
                    break;
                case 5:
                    new DeleteAirportByIDCommand().execute();
                    break;
                case 6:
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
        System.out.println("===== Airport Management System =====");
        System.out.println("1. View All Airports");
        System.out.println("2. Search Airports Menu");
        System.out.println("3. Add Airport");
        System.out.println("4. Edit Airport by ID");
        System.out.println("5. Delete Airport by ID");
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
