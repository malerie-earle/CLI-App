package com.keyin.cli.commands;

import com.keyin.cli.api.models.Booking;
import com.keyin.cli.api.models.Flight;
import com.keyin.cli.api.models.Passenger;

import java.util.List;
import java.util.Scanner;

public class AddBookingCommand {

    private List<Booking> bookingList;
    private List<Flight> flightList;
    private List<Passenger> passengerList;
    private Scanner scanner;

    public AddBookingCommand(List<Booking> bookingList, List<Flight> flightList, List<Passenger> passengerList, Scanner scanner) {
        this.bookingList = bookingList;
        this.flightList = flightList;
        this.passengerList = passengerList;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("===== Add Booking =====");

        System.out.print("Enter booking ID: ");
        long booking_ID = Long.parseLong(scanner.nextLine().trim());

        System.out.print("Enter flight ID: ");
        long flight_ID = Long.parseLong(scanner.nextLine().trim());

        System.out.print("Enter passenger ID: ");
        long passenger_ID = Long.parseLong(scanner.nextLine().trim());

        System.out.print("Enter seat row: ");
        int seatRow = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter seat column: ");
        int seatColumn = Integer.parseInt(scanner.nextLine().trim());

        Flight flight = findFlightById(flight_ID);
        Passenger passenger = findPassengerById(passenger_ID);

        if (flight == null) {
            System.out.println("Flight not found with ID: " + flight_ID);
            return;
        }

        if (passenger == null) {
            System.out.println("Passenger not found with ID: " + passenger_ID);
            return;
        }

        if (flight.isOccupied(seatRow, seatColumn)) {
            System.out.println("Seat " + seatRow + "-" + seatColumn + " is already occupied.");
            return;
        }

        Booking booking = new Booking(booking_ID, flight_ID, passenger_ID, seatRow, seatColumn);
        bookingList.add(booking);
        flight.setSeat(seatRow, seatColumn, booking);

        System.out.println("Booking added successfully:");
        System.out.println(booking);
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
