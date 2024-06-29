package com.keyin.cli.commands.booking;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;
import java.util.List;
import java.util.Scanner;

public class AddBookingCommand {
    private APIClient apiClient = new APIClient();
    private Scanner scanner;

    public AddBookingCommand() {
        this.scanner = new Scanner(System.in);
    }

    public void execute() {
        System.out.println("===== Add Booking =====");

        Passenger passenger = null;
        try {
            System.out.print("Enter id of the passenger: ");
            long id = Long.parseLong(scanner.nextLine().trim());
            passenger = apiClient.searchPassengerByID(id);
            if(passenger == null){
                System.out.print("No passenger with id of "+id+" found");
                return;
            }
        }catch (Exception e){
            System.out.println("Error:"+e.getMessage());
            return;
        }

        Flight flight = null;
        try {
            System.out.print("Enter id of the flight: ");
            long id = Long.parseLong(scanner.nextLine().trim());
            flight = apiClient.searchFlightByID(id);
            if(flight == null){
                System.out.print("No flight with id of "+id+" found");
                return;
            }
        }catch (Exception e){
            System.out.println("Error:"+e.getMessage());
            return;
        }
        System.out.println("======= Flight "+flight.getFlight_ID()+" =======");

        flight.displaySeatingChart();

        System.out.println("Please enter desired row: ");
        int row = Integer.parseInt(scanner.nextLine().trim());
        if (row > flight.getAircraft().getRows()){
            System.out.print("Out of bounds!");
            return;
        }

        System.out.println("Please enter desired column: ");
        int col = Integer.parseInt(scanner.nextLine().trim());
        if (col > flight.getAircraft().getColumns()){
            System.out.print("Out of bounds!");
            return;
        }

        try {
            Booking result = apiClient.addBooking(new Booking(0,flight.getFlight_ID(), passenger.getPassenger_ID(), row, col));
            if(result == null){
                System.out.print("Operation unsuccessful; Please try again!");
            }
            System.out.print("Booking successfully added!");
        } catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }

    }
}
