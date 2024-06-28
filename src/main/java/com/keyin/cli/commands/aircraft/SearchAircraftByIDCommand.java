package com.keyin.cli.commands.aircraft;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;

import java.util.Scanner;

public class SearchAircraftByIDCommand {
    private APIClient apiClient = new APIClient();
    private Scanner scanner;

    public SearchAircraftByIDCommand() {
        this.scanner = new Scanner(System.in);
    }

    public void execute() {
        System.out.println("===== Search Aircraft Menu =====");
        System.out.println("Enter aircraft id to retrieve : ");
        Long id = Long.parseLong(scanner.nextLine().trim());
        try {
            Aircraft targetAircraft = apiClient.searchAircraftByID(id);
            System.out.println(targetAircraft);
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
