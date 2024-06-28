package com.keyin.cli.commands.flight;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.Flight;

import java.util.Scanner;

public class ViewFlightSeatingChartCommand {
    private APIClient apiClient = new APIClient();
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("===== Flight Seating Chart View =====");
        System.out.println("Enter flight id to retrieve : ");
        Long id = Long.parseLong(scanner.nextLine().trim());
        try {
            Flight targetFlight = apiClient.searchFlightByID(id);
            targetFlight.displaySeatingChart();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
