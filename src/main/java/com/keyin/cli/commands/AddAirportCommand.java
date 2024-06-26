package com.keyin.cli.commands;

import com.keyin.rest.airport.Airport;

import java.util.List;
import java.util.Scanner;

public class AddAirportCommand {

    private List<Airport> airportList;
    private Scanner scanner;

    public AddAirportCommand(List<Airport> airportList, Scanner scanner) {
        this.airportList = airportList;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("===== Add Airport =====");

        System.out.print("Enter airport ID: ");
        long airport_ID = Long.parseLong(scanner.nextLine().trim());

        System.out.print("Enter airport code: ");
        String code = scanner.nextLine().trim();

        System.out.print("Enter airport name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter city: ");
        String city = scanner.nextLine().trim();

        System.out.print("Enter province: ");
        String province = scanner.nextLine().trim();

        Airport airport = new Airport(airport_ID, code, name, city, province);
        airportList.add(airport);

        System.out.println("Airport added successfully: " + airport);
    }
}
