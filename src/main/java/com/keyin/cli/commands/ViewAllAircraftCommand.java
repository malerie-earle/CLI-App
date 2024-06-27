package com.keyin.cli.commands;

import com.keyin.cli.api.models.Aircraft;

import java.util.List;

public class ViewAllAircraftCommand {

    private List<Aircraft> aircraftList;

    public ViewAllAircraftCommand(List<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
    }

    public void execute() {
        System.out.println("===== View All Aircraft =====");

        for (Aircraft aircraft : aircraftList) {
            System.out.println(aircraft);
        }
    }
}
