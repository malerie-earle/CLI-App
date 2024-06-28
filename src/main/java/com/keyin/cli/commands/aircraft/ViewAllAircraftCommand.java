package com.keyin.cli.commands.aircraft;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;
import java.util.List;

public class ViewAllAircraftCommand {
    APIClient apiClient = new APIClient();

    public void execute() {
        System.out.println("===== Viewing All Aircraft =====");
        try{
            List<Aircraft> aircraftList = apiClient.getAllAircrafts();

            if (aircraftList.isEmpty()) {
                System.out.println("No aircraft available.");
            } else {
                for (Aircraft aircraft : aircraftList) {
                    System.out.println(aircraft);
                }
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
