package com.keyin.cli.commands;

import com.keyin.rest.booking.Booking;
import com.keyin.rest.flight.Flight;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DeleteBookingByIDCommand {

    private List<Booking> bookingList;
    private List<Flight> flightList;
    private Scanner scanner;

    public DeleteBookingByIDCommand(List<Booking> bookingList, List<Flight> flightList, Scanner scanner) {
        this.bookingList = bookingList;
        this.flightList = flightList;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("===== Delete Booking by ID =====");
        System.out.print("Enter booking ID to delete: ");
        long booking_ID = Long.parseLong(scanner.nextLine().trim());

        Iterator<Booking> iterator = bookingList.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.getBooking_ID() == booking_ID) {
                iterator.remove();
                removeBookingFromFlight(booking);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Booking with ID " + booking_ID + " deleted successfully.");
        } else {
            System.out.println("Booking not found with ID: " + booking_ID);
        }
    }

    private void removeBookingFromFlight(Booking bookingToRemove) {
        for (Flight flight : flightList) {
            Booking[][] bookings = flight.getBookings();
            for (int row = 0; row < bookings.length; row++) {
                for (int col = 0; col < bookings[row].length; col++) {
                    if (bookings[row][col] != null && bookings[row][col].equals(bookingToRemove)) {
                        bookings[row][col] = null;
                        return;
                    }
                }
            }
        }
    }
}
