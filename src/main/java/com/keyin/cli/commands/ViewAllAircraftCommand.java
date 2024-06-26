package com.keyin.cli.commands;

import com.keyin.rest.aircraft.Aircraft;
import java.util.List;

public class ViewAllAircraftCommand {

    private List<Aircraft> aircraftList;

    public ViewAllAircraftCommand(List<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
    }

    public void execute() {
        System.out.println("===== Viewing All Aircraft =====");
        if (aircraftList.isEmpty()) {
            System.out.println("No aircraft available.");
        } else {
            for (Aircraft aircraft : aircraftList) {
                System.out.println(aircraft);
            }
        }
    }
}
