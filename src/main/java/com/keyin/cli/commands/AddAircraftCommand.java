package com.keyin.cli.commands;


import java.util.Scanner;

public class AddAircraftCommand {

    private List<Aircraft> aircraftList;
    private Scanner scanner;

    public AddAircraftCommand(List<Aircraft> aircraftList, Scanner scanner) {
        this.aircraftList = aircraftList;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("===== Add Aircraft =====");

        System.out.print("Enter aircraft ID: ");
        long aircraft_ID = Long.parseLong(scanner.nextLine().trim());

        System.out.print("Enter aircraft model: ");
        String model = scanner.nextLine().trim();

        System.out.print("Enter airline: ");
        String airline = scanner.nextLine().trim();

        System.out.print("Enter capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter number of rows: ");
        int rows = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter number of columns: ");
        int columns = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter number of aisles: ");
        int numAisles = Integer.parseInt(scanner.nextLine().trim());

        Aircraft aircraft = new Aircraft(aircraft_ID, model, airline, capacity, rows, columns, numAisles);
        aircraftList.add(aircraft);

        System.out.println("Aircraft added successfully:");
        System.out.println(aircraft);
    }
}
