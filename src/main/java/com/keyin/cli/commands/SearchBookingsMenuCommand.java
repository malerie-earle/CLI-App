package com.keyin.cli.commands;

import com.keyin.cli.api.models.*;
import java.util.List;
import java.util.Scanner;

public class SearchBookingsMenuCommand {

    private List<Booking> bookingList;
    private Scanner scanner;

    public SearchBookingsMenuCommand(List<Booking> bookingList, Scanner scanner) {
        this.bookingList = bookingList;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("===== Search Bookings Menu =====");
        System.out.print("Enter booking ID to search: ");
        long booking_ID = Long.parseLong(scanner.nextLine().trim());

        boolean found = false;
        for (Booking booking : bookingList) {
            if (booking.getBooking_ID() == booking_ID) {
                System.out.println(booking);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Booking not found with ID: " + booking_ID);
        }
    }
}
