package com.keyin.cli.commands.passenger;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;

import java.util.Scanner;

public class EditPassengerByIDCommand {

    private APIClient apiClient = new APIClient();
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("===== Edit Passenger by ID =====");
        System.out.print("Enter passenger ID: ");
        long passenger_ID = Long.parseLong(scanner.nextLine().trim());

        Passenger passengerToUpdate = new Passenger();
        try {
            passengerToUpdate = apiClient.searchPassengerByID(passenger_ID);
        }catch (Exception e){
            System.out.println("Passenger not found with ID: " + passenger_ID);
        }

        if (passengerToUpdate == null) {
            System.out.println("Passenger not found with ID: " + passenger_ID);
            return;
        }

        System.out.println("Enter new first name (current: " + passengerToUpdate.getFirst_name() + "): ");
        String fName = scanner.nextLine().trim();
        passengerToUpdate.setFirst_name(fName);

        System.out.println("Enter new last name (current: " + passengerToUpdate.getLast_name() + "): ");
        String lName = scanner.nextLine().trim();
        passengerToUpdate.setLast_name(lName);

        System.out.println("Enter new email (current: " + passengerToUpdate.getEmail() + "): ");
        String email = scanner.nextLine().trim();
        passengerToUpdate.setEmail(email);


        try {
            apiClient.updatePassenger(passenger_ID,passengerToUpdate);
            System.out.println("Passenger updated successfully:");
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
