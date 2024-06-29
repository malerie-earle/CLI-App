package com.keyin.cli.menus;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.commands.booking.AddBookingCommand;
import com.keyin.cli.commands.booking.DeleteBookingByIDCommand;
import com.keyin.cli.commands.booking.SearchBookingsByIDCommand;
import com.keyin.cli.commands.booking.ViewAllBookingsCommand;

import java.util.Scanner;

public class BookingMenu {

    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    new ViewAllBookingsCommand().execute();
                    break;
                case 2:
                    new SearchBookingsByIDCommand().execute();
                    break;
                case 3:
                    new AddBookingCommand().execute();
                    break;
                case 4:
                    new DeleteBookingByIDCommand().execute();
                    break;
                case 5:
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
        System.out.println("===== Booking Management System =====");
        System.out.println("1. View All Bookings");
        System.out.println("2. Search Bookings Menu");
        System.out.println("3. Add Booking");
        System.out.println("4. Cancel Booking");
        System.out.println("5. Exit");
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
