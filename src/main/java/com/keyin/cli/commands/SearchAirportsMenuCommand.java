package com.keyin.cli.commands;

import com.keyin.cli.api.models.*;
import java.util.List;
import java.util.Scanner;

public class SearchAirportsMenuCommand {

    private List<Airport> airportList;
    private Scanner scanner;

    public SearchAirportsMenuCommand(List<Airport> airportList, Scanner scanner) {
        this.airportList = airportList;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("===== Search Airports Menu =====");
        System.out.println("Enter airport code to search: ");
        String code = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (Airport airport : airportList) {
            if (airport.getCode().toLowerCase().contains(code)) {
                System.out.println(airport);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No airports found with code containing '" + code + "'.");
        }
    }
}
