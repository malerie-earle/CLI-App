package com.keyin.cli.commands;

import com.keyin.rest.booking.Booking;
import com.keyin.rest.flight.Flight;
import com.keyin.rest.passenger.Passenger;
import java.util.List;
import java.util.Scanner;

public class EditBookingByIDCommand {

    private List<Booking> bookingList;
    private List<Flight> flightList;
    private List<Passenger> passengerList;
    private Scanner scanner;

    public EditBookingByIDCommand(List<Booking> bookingList, List<Flight> flightList, List<Passenger> passengerList, Scanner scanner) {
        this.bookingList = bookingList;
        this.flightList = flightList;
        this.passengerList = passengerList;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("===== Edit Booking by ID =====");
        System.out.print("Enter booking ID: ");
        long booking_ID = Long.parseLong(scanner.nextLine().trim());

        Booking bookingToUpdate = null;
        for (Booking booking : bookingList) {
            if (booking.getBooking_ID() == booking_ID) {
                bookingToUpdate = booking;
                break;
            }
        }

        if (bookingToUpdate == null) {
            System.out.println("Booking not found with ID: " + booking_ID);
            return;
        }

        System.out.println("Enter new flight ID (current: " + bookingToUpdate.getFlight_ID() + "): ");
        long newFlight_ID = Long.parseLong(scanner.nextLine().trim());

        System.out.println("Enter new passenger ID (current: " + bookingToUpdate.getPassenger_ID() + "): ");
        long newPassenger_ID = Long.parseLong(scanner.nextLine().trim());

        System.out.println("Enter new seat row (current: " + bookingToUpdate.getSeatRow() + "): ");
        int newSeatRow = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter new seat column (current: " + bookingToUpdate.getSeatColumn() + "): ");
        int newSeatColumn = Integer.parseInt(scanner.nextLine().trim());

        Flight newFlight = findFlightById(newFlight_ID);
        Passenger newPassenger = findPassengerById(newPassenger_ID);

        if (newFlight == null) {
            System.out.println("Flight not found with ID: " + newFlight_ID);
            return;
        }

        if (newPassenger == null) {
            System.out.println("Passenger not found with ID: " + newPassenger_ID);
            return;
        }

        if (newFlight.isOccupied(newSeatRow, newSeatColumn)) {
            System.out.println("Seat " + newSeatRow + "-" + newSeatColumn + " is already occupied.");
            return;
        }

        bookingToUpdate.setFlight_ID(newFlight_ID);
        bookingToUpdate.setPassenger_ID(newPassenger_ID);
        bookingToUpdate.setSeatRow(newSeatRow);
        bookingToUpdate.setSeatColumn(newSeatColumn);

        System.out.println("Booking updated successfully:");
        System.out.println(bookingToUpdate);
    }

    private Flight findFlightById(long flight_ID) {
        for (Flight flight : flightList) {
            if (flight.getFlight_ID() == flight_ID) {
                return flight;
            }
        }
        return null;
    }

    private Passenger findPassengerById(long passenger_ID) {
        for (Passenger passenger : passengerList) {
            if (passenger.getPassenger_ID() == passenger_ID) {
                return passenger;
            }
        }
        return null;
    }
}
