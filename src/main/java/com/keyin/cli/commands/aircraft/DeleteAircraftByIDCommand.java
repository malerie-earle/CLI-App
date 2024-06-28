package com.keyin.cli.commands.aircraft;

import com.keyin.cli.api.APIClient;

import java.util.Scanner;

public class DeleteAircraftByIDCommand {

    private APIClient apiClient = new APIClient();
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("===== Delete Aircraft by ID =====");
        System.out.print("Enter aircraft ID to delete: ");
        long aircraft_ID = Long.parseLong(scanner.nextLine().trim());
        try {
            if(apiClient.searchAircraftByID(aircraft_ID) == null){
                System.out.println("Aircraft does not exist");
                return;
            }
            apiClient.deleteAircraft(aircraft_ID);
            System.out.println("Aircraft Deleted");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
