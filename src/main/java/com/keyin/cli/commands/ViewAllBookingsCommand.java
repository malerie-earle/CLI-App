package com.keyin.cli.commands;

import com.keyin.cli.api.models.*;
import java.util.List;

public class ViewAllBookingsCommand {

    private List<Booking> bookingList;

    public ViewAllBookingsCommand(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public void execute() {
        System.out.println("===== Viewing All Bookings =====");
        if (bookingList.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            for (Booking booking : bookingList) {
                System.out.println(booking);
            }
        }
    }
}
