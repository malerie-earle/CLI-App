package com.keyin.cli.commands.flight;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.Flight;

import java.util.Scanner;

public class SearchFlightsByIDCommand {
    private APIClient apiClient = new APIClient();
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("===== Search Flight Menu =====");
        System.out.println("Enter flight id to retrieve : ");
        Long id = Long.parseLong(scanner.nextLine().trim());
        try {
            Flight targetFlight = apiClient.searchFlightByID(id);
            System.out.println(targetFlight);
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
