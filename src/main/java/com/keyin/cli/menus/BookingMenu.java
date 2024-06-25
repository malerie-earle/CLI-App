package com.keyin.cli.menus;

import java.util.Scanner;

public class BookingMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    ViewAllBookings();
                    break;
                case 2:
                    SearchBookingsMenu();
                    break;
                case 3:
                    AddBooking();
                    break;
                case 4:
                    EditBookingByID();
                    break;
                case 5:
                    DeleteBookingByID();
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
        System.out.println("===== Booking Management System =====");
        System.out.println("1. View All Bookings");
        System.out.println("2. Search Bookings Menu");
        System.out.println("3. Add Booking");
        System.out.println("4. Edit Booking by ID");
        System.out.println("5. Delete Booking by ID");
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
