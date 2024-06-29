package com.keyin.cli;

import com.keyin.cli.menus.*;
import com.keyin.cli.utils.InputReader;

public class FlightCLI {
    private static final InputReader inputReader = new InputReader();

    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("   _____ _  ____     __  _      ____   _____ _______   __");
        System.out.println("  / ____| |/ /\\ \\   / / | |    / __ \\ / ____|_   _\\ \\ / /");
        System.out.println(" | (___ | ' /  \\ \\_/ /  | |   | |  | | |  __  | |  \\ V / ");
        System.out.println("  \\___ \\|  <    \\   /   | |   | |  | | | |_ | | |   > <  ");
        System.out.println(" |_____/|_|\\_\\   |_|    |______\\____/ \\_____|_____/_/ \\_\\");
        System.out.println("                                                                ");
        System.out.println("============================================================");
        System.out.println("              .------,");
        System.out.println("              =\\      \\");
        System.out.println(" .---.         =\\      \\");
        System.out.println(" | C~ \\         =\\      \\");
        System.out.println(" |     `----------'------'----------,");
        System.out.println(".'     LI.-.LI LI LI LI LI LI LI.-.LI`-.");
        System.out.println("\\ _/.____|_|______.------,______|_|_____)");
        System.out.println("                 /      /");
        System.out.println("               =/      /");
        System.out.println("              =/      /");
        System.out.println("             =/      /");
        System.out.println("             /_____,");
        System.out.println("============================================================");
        System.out.println("      Welcome to SkyLogix: Your Aerospace Navigator");
        System.out.println("============================================================");
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
