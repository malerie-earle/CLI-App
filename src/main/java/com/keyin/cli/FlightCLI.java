package com.keyin.cli;

import com.keyin.cli.menus.*;
import com.keyin.cli.utils.InputReader;

public class FlightCLI {
    private static final InputReader inputReader = new InputReader();

    public static void main(String[] args) {
        System.out.println("\033[1;96m============================================================\033[0m");
        System.out.println("\033[1;94m   _____ _  ____     __  _      ____   _____ _______   __\033[0m");
        System.out.println("\033[1;94m  / ____| |/ /\\ \\   / / | |    / __ \\ / ____|_   _\\ \\ / /\033[0m");
        System.out.println("\033[1;94m | (___ | ' /  \\ \\_/ /  | |   | |  | | |  __  | |  \\ V / \033[0m");
        System.out.println("\033[1;94m  \\___ \\|  <    \\   /   | |   | |  | | | |_ | | |   > <  \033[0m");
        System.out.println("\033[1;94m  ____) | . \\   | |    |______| |  | | |__| | | |  / . \\ \033[0m");
        System.out.println("\033[1;94m |_____/|_|\\_\\  |_|    |______|____/ \\_____|_____/|_|\\_\\\033[0m");
        System.out.println("                                                                ");
        System.out.println("\033[1;96m============================================================\033[0m");
        System.out.println("\033[1;36m                       .------,\033[0m");
        System.out.println("\033[1;36m                       =\\      \\\033[0m");
        System.out.println("\033[1;36m          .---.         =\\      \\\033[0m");
        System.out.println("\033[1;36m          | C~ \\         =\\      \\\033[0m");
        System.out.println("\033[1;36m          |     `----------'------'----------,\033[0m");
        System.out.println("\033[1;36m         .'     LI.-.LI LI LI LI LI LI LI.-.LI`-.\033[0m");
        System.out.println("\033[1;36m        \\ _/.____|_|______.------,______|_|_____)\033[0m");
        System.out.println("\033[1;36m                          /      /\033[0m");
        System.out.println("\033[1;36m                        =/      /\033[0m");
        System.out.println("\033[1;36m                       =/      /\033[0m");
        System.out.println("\033[1;36m                      =/      /\033[0m");
        System.out.println("\033[1;36m                      /_____,\033[0m");
        System.out.println("\033[1;96m============================================================\033[0m");
        System.out.println("\033[1;94m      Welcome to SkyLogix: Your Aerospace Navigator\033[0m");
        System.out.println("\033[1;96m============================================================\033[0m");
        while (true) {
            printMainMenu();
            int choice = inputReader.readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    new FlightMenu().display();
                    break;
                case 2:
                    new BookingMenu().display();
                    break;
                case 3:
                    new PassengerMenu().display();
                    break;
                case 4:
                    new AircraftMenu().display();
                    break;
                case 5:
                    new AirportMenu().display();
                    break;
                case 6:
                    System.out.println("Exiting FlightCLI. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("                       MAIN MENU ");
        System.out.println("============================================================");
        System.out.println("1. Flight Management");
        System.out.println("2. Booking Management");
        System.out.println("3. Passenger Management");
        System.out.println("4. Aircraft Management");
        System.out.println("5. Airport Management");
        System.out.println("6. Exit");
    }
}
