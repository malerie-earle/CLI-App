package com.keyin.cli.commands;

import com.keyin.rest.aircraft.Aircraft;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DeleteAircraftByIDCommand {

    private List<Aircraft> aircraftList;
    private Scanner scanner;

    public DeleteAircraftByIDCommand(List<Aircraft> aircraftList, Scanner scanner) {
        this.aircraftList = aircraftList;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("===== Delete Aircraft by ID =====");
        System.out.print("Enter aircraft ID to delete: ");
        long aircraft_ID = Long.parseLong(scanner.nextLine().trim());

        Iterator<Aircraft> iterator = aircraftList.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Aircraft aircraft = iterator.next();
            if (aircraft.getAircraft_ID() == aircraft_ID) {
                iterator.remove();
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Aircraft with ID " + aircraft_ID + " deleted successfully.");
        } else {
            System.out.println("Aircraft not found with ID: " + aircraft_ID);
        }
    }
}
