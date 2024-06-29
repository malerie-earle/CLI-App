package com.keyin.cli.commands.booking;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.Booking;

import java.util.Scanner;

public class SearchBookingsByIDCommand {
    private APIClient apiClient = new APIClient();
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("===== Search Booking Menu =====");
        System.out.println("Enter booking id to retrieve : ");
        Long id = Long.parseLong(scanner.nextLine().trim());
        try {
            Booking targetBooking = apiClient.searchBookingByID(id);
            System.out.println(targetBooking);
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
