package com.keyin.cli.commands.airport;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;

import java.util.Scanner;

public class EditAirportByIDCommand {

    private APIClient apiClient = new APIClient();
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("===== Edit Airport by ID =====");
        System.out.print("Enter airport ID: ");
        long airport_ID = Long.parseLong(scanner.nextLine().trim());

        Airport airportToUpdate = new Airport();
        try {
            airportToUpdate = apiClient.searchAirportByID(airport_ID);
        }catch (Exception e){
            System.out.println("Airport not found with ID: " + airport_ID);
        }

        if (airportToUpdate == null) {
            System.out.println("Airport not found with ID: " + airport_ID);
            return;
        }

        System.out.println("Enter new name (current: " + airportToUpdate.getName() + "): ");
        String newName = scanner.nextLine().trim();
        airportToUpdate.setName(newName);

        System.out.println("Enter new airport (current: " + airportToUpdate.getCode() + "): ");
        String newCode = scanner.nextLine().trim();
        airportToUpdate.setCode(newCode);

        System.out.println("Enter new city (current: " + airportToUpdate.getCity() + "): ");
        String newCity = scanner.nextLine().trim();
        airportToUpdate.setCity(newCity);

        System.out.println("Enter new province (current: " + airportToUpdate.getProvince() + "): ");
        String newProvince = scanner.nextLine().trim();
        airportToUpdate.setProvince(newProvince);

        try {
            apiClient.updateAirport(airport_ID,airportToUpdate);
            System.out.println("Airport updated successfully:");
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
