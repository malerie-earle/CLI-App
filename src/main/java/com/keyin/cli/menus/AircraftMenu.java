package com.keyin.cli.menus;

import com.keyin.cli.*;
import com.keyin.cli.commands.aircraft.*;
import com.keyin.cli.commands.flight.*;
import com.keyin.cli.commands.passenger.*;
import com.keyin.cli.commands.airport.*;
import com.keyin.cli.commands.booking.*;
import com.keyin.cli.api.models.*;
import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;
import java.util.List;


import java.util.Scanner;

public class AircraftMenu {

    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    new ViewAllAircraftCommand().execute();
                    break;
                case 2:
                    new SearchAircraftByIDCommand().execute();
                    break;
                case 3:
                    new AddAircraftCommand().execute();
                    break;
                case 4:
                    new EditAircraftByIDCommand().execute();
                    break;
                case 5:
                    new DeleteAircraftByIDCommand().execute();
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
