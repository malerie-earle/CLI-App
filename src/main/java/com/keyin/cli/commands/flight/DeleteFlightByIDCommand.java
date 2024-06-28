package com.keyin.cli.commands.flight;

import com.keyin.cli.api.APIClient;

import java.util.Scanner;

public class DeleteFlightByIDCommand {

    private APIClient apiClient = new APIClient();
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("===== Delete Flight by ID =====");
        System.out.print("Enter flight ID to delete: ");
        long flight_ID = Long.parseLong(scanner.nextLine().trim());
        try {
            if(apiClient.searchFlightByID(flight_ID) == null){
                System.out.println("Flight does not exist");
                return;
            }
            apiClient.deleteFlight(flight_ID);
            System.out.println("Flight Deleted");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
