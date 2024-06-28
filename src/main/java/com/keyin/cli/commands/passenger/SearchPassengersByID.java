package com.keyin.cli.commands.passenger;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.Passenger;

import java.util.Scanner;

public class SearchPassengersByID {
    private APIClient apiClient = new APIClient();
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("===== Search Passenger Menu =====");
        System.out.println("Enter passenger id to retrieve : ");
        Long id = Long.parseLong(scanner.nextLine().trim());
        try {
            Passenger targetPassenger = apiClient.searchPassengerByID(id);
            System.out.println(targetPassenger);
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
