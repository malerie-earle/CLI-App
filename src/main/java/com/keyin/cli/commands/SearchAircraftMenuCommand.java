package com.keyin.cli.commands;

import com.keyin.rest.aircraft.Aircraft;
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
        System.out.println("===== Search Aircraft Menu =====");
        System.out.println("Enter aircraft model to search: ");
        String model = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (Aircraft aircraft : aircraftList) {
            if (aircraft.getModel().toLowerCase().contains(model)) {
                System.out.println(aircraft);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No aircraft found with model containing '" + model + "'.");
        }
    }
}
