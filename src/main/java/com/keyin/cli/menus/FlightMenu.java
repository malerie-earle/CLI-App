package com.keyin.cli.menus;

import java.util.Scanner;

    public class FlightMenu {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                printMenu();
                int choice = getUserChoice(scanner);

                switch (choice) {
                    case 1:
                        ViewAllFlights();
                        break;
                    case 2:
                        SearchFlightMenu();
                        break;
                    case 3:
                        AddFlight();
                        break;
                    case 4:
                        EditFlightByID();
                        break;
                    case 5:
                        DeleteFlightByID();
                        break;
                    case 6:
                        SeatingChartMenu();
                        break;
                    case 7:
                        exit = true;
                        System.out.println("Exiting... Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            scanner.close();
        }

        private static void printMenu() {
            System.out.println();
            System.out.println("===== Flight Management System =====");
            System.out.println("1. View All Flights");
            System.out.println("2. Search Flights Menu");
            System.out.println("3. Add Flight");
            System.out.println("4. Edit Flight by ID");
            System.out.println("5. Delete Flight by ID");
            System.out.println("6. Seating Chart Menu");
            System.out.println("7. Exit");
            System.out.println();
            System.out.print("Choose an option: ");
        }

        private static int getUserChoice(Scanner scanner) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                System.out.print("Choose an option: ");
            }
            return scanner.nextInt();
        }

    }
