package com.keyin.cli.commands;

import com.keyin.cli.api.models.*;
import java.util.List;
import java.util.Scanner;

public class EditAircraftByIDCommand {

    private List<Aircraft> aircraftList;
    private Scanner scanner;

    public EditAircraftByIDCommand(List<Aircraft> aircraftList, Scanner scanner) {
        this.aircraftList = aircraftList;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("===== Edit Aircraft by ID =====");
        System.out.print("Enter aircraft ID: ");
        long aircraft_ID = Long.parseLong(scanner.nextLine().trim());

        Aircraft aircraftToUpdate = null;
        for (Aircraft aircraft : aircraftList) {
            if (aircraft.getAircraft_ID() == aircraft_ID) {
                aircraftToUpdate = aircraft;
                break;
            }
        }

        if (aircraftToUpdate == null) {
            System.out.println("Aircraft not found with ID: " + aircraft_ID);
            return;
        }

        System.out.println("Enter new model (current: " + aircraftToUpdate.getModel() + "): ");
        String newModel = scanner.nextLine().trim();
        aircraftToUpdate.setModel(newModel);

        System.out.println("Enter new airline (current: " + aircraftToUpdate.getAirline() + "): ");
        String newAirline = scanner.nextLine().trim();
        aircraftToUpdate.setAirline(newAirline);

        System.out.println("Enter new capacity (current: " + aircraftToUpdate.getCapacity() + "): ");
        int newCapacity = Integer.parseInt(scanner.nextLine().trim());
        aircraftToUpdate.setCapacity(newCapacity);

        System.out.println("Enter new number of rows (current: " + aircraftToUpdate.getRows() + "): ");
        int newRows = Integer.parseInt(scanner.nextLine().trim());
        aircraftToUpdate.setRows(newRows);

        System.out.println("Enter new number of columns (current: " + aircraftToUpdate.getColumns() + "): ");
        int newColumns = Integer.parseInt(scanner.nextLine().trim());
        aircraftToUpdate.setColumns(newColumns);

        System.out.println("Enter new number of aisles (current: " + aircraftToUpdate.getNumAisles() + "): ");
        int newNumAisles = Integer.parseInt(scanner.nextLine().trim());
        aircraftToUpdate.setNumAisles(newNumAisles);

        System.out.println("Aircraft updated successfully:");
        System.out.println(aircraftToUpdate);
    }
}
