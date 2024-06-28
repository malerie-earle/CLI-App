package com.keyin.cli.commands.flight;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;

import java.util.Scanner;

public class EditFlightByIDCommand {

    private APIClient apiClient = new APIClient();
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("===== Edit Flight by ID =====");
        Flight flightToUpdate = null;
        while (true){
            try {
                System.out.print("Enter id of flight to update: ");
                long id = Long.parseLong(scanner.nextLine().trim());
                flightToUpdate = apiClient.searchFlightByID(id);
                break;
            }catch (Exception e){
                System.out.println("Error:"+e.getMessage());
            }
        }

        while (true){
            try {
                System.out.print("Enter id of origin airport: ");
                long id = Long.parseLong(scanner.nextLine().trim());
                flightToUpdate.setOrigin(apiClient.getAirportbyID(id));
                break;
            }catch (Exception e){
                System.out.println("Error:"+e.getMessage());
            }
        }
        while (true){
            try {
                System.out.print("Enter id of destination airport: ");
                long id = Long.parseLong(scanner.nextLine().trim());
                flightToUpdate.setDestination(apiClient.getAirportbyID(id));
                break;
            }catch (Exception e){
                System.out.println("Error: e.getMessage()");
            }
        }

        System.out.print("Enter departure time in 'YYYY-MM-DDTHH:MM:SS' format: ");
        flightToUpdate.setDeparture_time(scanner.nextLine().trim());

        System.out.print("Enter arrival time in 'YYYY-MM-DDTHH:MM:SS' format: ");
        flightToUpdate.setArrival_time(scanner.nextLine().trim());

        try {
            apiClient.updateFlight(flightToUpdate.getFlight_ID(), flightToUpdate);
            System.out.println("Flight updated successfully:");
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
