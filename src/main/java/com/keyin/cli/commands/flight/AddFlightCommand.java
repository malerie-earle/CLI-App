package com.keyin.cli.commands.flight;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;
import java.util.List;
import java.util.Scanner;

import static com.keyin.cli.api.models.Flight.Status.ON_TIME;

public class AddFlightCommand {
    private APIClient apiClient = new APIClient();
    private Scanner scanner;

    public AddFlightCommand() {
        this.scanner = new Scanner(System.in);
    }

    public void execute() {
        System.out.println("===== Add Flight =====");

        Airport origin = null;
        try {
            System.out.print("Enter id of origin airport: ");
            long id = Long.parseLong(scanner.nextLine().trim());
            origin = apiClient.getAirportbyID(id);
            if(origin == null){
                System.out.print("No airport with id of "+id+" found");
            }
        }catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }

        Airport destination = null;
        try {
            System.out.print("Enter id of destination airport: ");
            long id = Long.parseLong(scanner.nextLine().trim());
            destination = apiClient.getAirportbyID(id);
            if(destination == null){
                System.out.print("No airport with id of "+id+" found");
            }
        }catch (Exception e){
            System.out.println("Error: e.getMessage()");
        }

        Aircraft aircraft = null;
        try {
            System.out.print("Enter id of the aircraft: ");
            long id = Long.parseLong(scanner.nextLine().trim());
            aircraft = apiClient.searchAircraftByID(id);
            if(aircraft == null){
                System.out.print("No aircraft with id of "+id+" found");
            }
        }catch (Exception e){
            System.out.println("Error: e.getMessage()");
        }

        System.out.print("Enter departure time in 'YYYY-MM-DDTHH:MM:SS' format: ");
        String deptTime = scanner.nextLine().trim();

        System.out.print("Enter arrival time in 'YYYY-MM-DDTHH:MM:SS' format: ");
        String arrivTime = scanner.nextLine().trim();

        Flight flight = new Flight(0,origin,destination,aircraft,deptTime,arrivTime,ON_TIME);

        try{
            apiClient.addFlight(flight);
            System.out.println("Flight added successfully:");
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
