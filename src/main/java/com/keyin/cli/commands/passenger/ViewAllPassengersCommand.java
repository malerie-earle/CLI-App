package com.keyin.cli.commands.passenger;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;

import java.util.List;

public class ViewAllPassengersCommand {
    APIClient apiClient = new APIClient();

    public void execute() {
        System.out.println("===== Viewing All Passengers =====");
        try{
            List<Passenger> passengerList = apiClient.getAllPassengers();

            if (passengerList.isEmpty()) {
                System.out.println("No passengers available.");
            } else {
                for (Passenger passenger : passengerList) {
                    System.out.println(passenger);
                }
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
