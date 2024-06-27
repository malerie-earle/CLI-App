package com.keyin.cli.commands;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.Airport;

import java.io.IOException;
import java.util.Scanner;

public class AddAirportCommand {
    private final APIClient apiClient;

    public AddAirportCommand(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter airport code: ");
        String code = scanner.nextLine().trim();
        System.out.print("Enter airport name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter airport city: ");
        String city = scanner.nextLine().trim();
        System.out.print("Enter airport province: ");
        String province = scanner.nextLine().trim();

        // Create a new Airport object with the user-provided details
        Airport airport = new Airport(0, code, name, city, province);

        try {
            apiClient.addAirport(airport);
            System.out.println("Airport added successfully.");
        } catch (IOException e) {
            System.err.println("Error adding airport: " + e.getMessage());
        }
    }
}
