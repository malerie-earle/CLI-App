package com.keyin.cli.commands.airport;

import com.keyin.cli.api.APIClient;

import java.util.Scanner;

public class DeleteAirportByIDCommand {

    private APIClient apiClient = new APIClient();
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("===== Delete Airport by ID =====");
        System.out.print("Enter airport ID to delete: ");
        long airport_ID = Long.parseLong(scanner.nextLine().trim());
        try {
            if(apiClient.searchAirportByID(airport_ID) == null){
                System.out.println("Airport does not exist");
                return;
            }
            apiClient.deleteAirport(airport_ID);
            System.out.println("Airport Deleted");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
