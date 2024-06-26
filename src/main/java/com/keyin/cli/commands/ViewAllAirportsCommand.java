package com.keyin.cli.commands;

import com.keyin.rest.airport.Airport;
import java.util.List;

public class ViewAllAirportsCommand {

    private List<Airport> airportList;

    public ViewAllAirportsCommand(List<Airport> airportList) {
        this.airportList = airportList;
    }

    public void execute() {
        System.out.println("===== Viewing All Airports =====");
        if (airportList.isEmpty()) {
            System.out.println("No airports available.");
        } else {
            for (Airport airport : airportList) {
                System.out.println(airport);
            }
        }
    }
}
