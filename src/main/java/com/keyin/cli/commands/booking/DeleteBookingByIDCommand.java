package com.keyin.cli.commands.booking;

import com.keyin.cli.api.APIClient;

import java.util.Scanner;

public class DeleteBookingByIDCommand {

    private APIClient apiClient = new APIClient();
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("===== Delete Booking by ID =====");
        System.out.print("Enter booking ID to delete: ");
        long booking_ID = Long.parseLong(scanner.nextLine().trim());
        try {
            if(apiClient.searchBookingByID(booking_ID) == null){
                System.out.println("Booking does not exist");
                return;
            }
            apiClient.deleteBooking(booking_ID);
            System.out.println("Booking Deleted");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
