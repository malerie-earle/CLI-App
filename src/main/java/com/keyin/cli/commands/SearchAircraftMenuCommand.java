package com.keyin.cli.commands;

import com.keyin.cli.api.models.Aircraft;

import java.util.List;
import java.util.Scanner;

public class SearchAircraftMenuCommand {

    private List<Aircraft> aircraftList;
    private Scanner scanner;

    public SearchAircraftMenuCommand(List<Aircraft> aircraftList, Scanner scanner) {
        this.aircraftList = aircraftList;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.println("===== Search Aircraft =====");

        System.out.print("Enter aircraft ID: ");
        long aircraftId = Long.parseLong(scanner.nextLine().trim());

        Aircraft aircraft = findAircraftById(aircraftId);

        if (aircraft != null) {
            System.out.println("Aircraft found: " + aircraft);
        } else {
            System.out.println("No aircraft found with ID: " + aircraftId);
        }
    }

    private Aircraft findAircraftById(long aircraftId) {
        for (Aircraft aircraft : aircraftList) {
            if (aircraft.getAircraftId() == aircraftId) {
                return aircraft;
            }
        }
        return null;
    }
}
