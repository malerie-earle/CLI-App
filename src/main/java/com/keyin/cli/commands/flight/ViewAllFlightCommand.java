package com.keyin.cli.commands.flight;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;
import java.util.List;

public class ViewAllFlightCommand {
    APIClient apiClient = new APIClient();

    public void execute() {
        System.out.println("===== Viewing All Flight =====");
        try{
            List<Flight> flightList = apiClient.getAllFlights();
            if (flightList.isEmpty()) {
                System.out.println("No flight available.");
            } else {
                for (Flight flight : flightList) {
                    System.out.println(flight);
                }
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
