package com.keyin.cli.commands.passenger;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;
import java.util.List;
import java.util.Scanner;

public class AddPassengerCommand {
    private APIClient apiClient = new APIClient();
    private Scanner scanner;

    public AddPassengerCommand() {
        this.scanner = new Scanner(System.in);
    }

    public void execute() {
        System.out.println("===== Add Passenger =====");

        System.out.print("Enter passenger first name: ");
        String fName = scanner.nextLine().trim();

        System.out.print("Enter passenger last name: ");
        String lName = scanner.nextLine().trim();

        System.out.print("Enter passenger email: ");
        String email = scanner.nextLine().trim();

        Passenger passenger = new Passenger(0,fName,lName,email);

        try{
            apiClient.addPassenger(passenger);
            System.out.println("Passenger added successfully:");
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
