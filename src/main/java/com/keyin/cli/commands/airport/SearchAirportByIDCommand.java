package com.keyin.cli.commands.airport;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;

import java.util.Scanner;

public class SearchAirportByIDCommand {
    private APIClient apiClient = new APIClient();
    private Scanner scanner;

    public SearchAirportByIDCommand() {
        this.scanner = new Scanner(System.in);
    }

    public void execute() {
        System.out.println("===== Search Airport Menu =====");
        System.out.println("Enter airport id to retrieve : ");
        Long id = Long.parseLong(scanner.nextLine().trim());
        try {
            Airport targetAirport = apiClient.searchAirportByID(id);
            System.out.println(targetAirport);
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}