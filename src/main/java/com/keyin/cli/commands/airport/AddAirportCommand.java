package com.keyin.cli.commands.airport;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;
import java.util.List;
import java.util.Scanner;

public class AddAirportCommand {
    private APIClient apiClient = new APIClient();
    private Scanner scanner;

    public AddAirportCommand() {
        this.scanner = new Scanner(System.in);
    }

    public void execute() {
        System.out.println("===== Add Airport =====");

        System.out.print("Enter airport Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter airport Code: ");
        String code = scanner.nextLine().trim();

        System.out.print("Enter airport City: ");
        String city = scanner.nextLine().trim();

        System.out.print("Enter airport Province: ");
        String province = scanner.nextLine().trim();

        Airport airport = new Airport(0, name,code,city,province);

        try{
            apiClient.addAirport(airport);
            System.out.println("Airport added successfully:");
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
