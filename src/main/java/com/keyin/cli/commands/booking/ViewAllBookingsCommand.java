package com.keyin.cli.commands.booking;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.api.models.*;
import java.util.List;

public class ViewAllBookingsCommand {
    APIClient apiClient = new APIClient();

    public void execute() {
        System.out.println("===== Viewing All Bookings =====");
        try{
            List<Booking> bookingList = apiClient.getAllBookings();
            if (bookingList.isEmpty()) {
                System.out.println("No Booking available.");
            } else {
                for (Booking booking : bookingList) {
                    System.out.println(booking);
                }
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
