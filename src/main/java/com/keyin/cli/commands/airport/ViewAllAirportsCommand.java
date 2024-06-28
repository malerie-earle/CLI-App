package com.keyin.cli.commands.airport;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;
import java.util.List;

public class ViewAllAirportsCommand {
    APIClient apiClient = new APIClient();

    public void execute() {
        System.out.println("===== Viewing All Airport =====");
        try{
            List<Airport> airportList = apiClient.getAllAirports();

            if (airportList.isEmpty()) {
                System.out.println("No airport available.");
            } else {
                for (Airport airport : airportList) {
                    System.out.println(airport);
                }
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
