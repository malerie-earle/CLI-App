package com.keyin.cli.commands.aircraft;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;
import java.util.List;
import java.util.Scanner;

public class AddAircraftCommand {
    private APIClient apiClient = new APIClient();
    private Scanner scanner;

    public AddAircraftCommand() {
        this.scanner = new Scanner(System.in);
    }

    public void execute() {
        System.out.println("===== Add Aircraft =====");

        System.out.print("Enter aircraft model: ");
        String model = scanner.nextLine().trim();

        System.out.print("Enter airline: ");
        String airline = scanner.nextLine().trim();

        System.out.print("Enter capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter number of rows: ");
        int rows = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter number of columns: ");
        int columns = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter number of aisles: ");
        int numAisles = Integer.parseInt(scanner.nextLine().trim());

        Aircraft aircraft = new Aircraft(0, model, airline, capacity, rows, columns, numAisles);

        try{
            apiClient.addAircraft(aircraft);
            System.out.println("Aircraft added successfully:");
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
