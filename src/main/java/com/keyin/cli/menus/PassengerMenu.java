package com.keyin.cli.menus;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.commands.aircraft.SearchAircraftByIDCommand;
import com.keyin.cli.commands.passenger.*;

import java.util.Scanner;

public class PassengerMenu {

    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    new ViewAllPassengersCommand().execute();
                    break;
                case 2:
                    new SearchPassengersByID().execute();
                    break;
                case 3:
                    new AddPassengerCommand().execute();
                    break;
                case 4:
                    new EditPassengerByIDCommand().execute();
                    break;
                case 5:
                    new DeletePassengerByIDCommand().execute();
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
