package com.keyin.cli.commands.passenger;

import com.keyin.cli.api.APIClient;

import java.util.Scanner;

public class DeletePassengerByIDCommand {

    private APIClient apiClient = new APIClient();
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("===== Delete passenger by ID =====");
        System.out.print("Enter passenger ID to delete: ");
        long passenger_ID = Long.parseLong(scanner.nextLine().trim());
        try {
            if(apiClient.searchPassengerByID(passenger_ID) == null){
                System.out.println("passenger does not exist");
                return;
            }
            apiClient.deletePassenger(passenger_ID);
            System.out.println("passenger Deleted");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
