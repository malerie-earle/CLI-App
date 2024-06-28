package com.keyin.cli.menus;

import com.keyin.cli.api.APIClient;
import com.keyin.cli.commands.flight.*;

import java.util.Scanner;

    public class FlightMenu {

        private static boolean execute(int choice) {
            switch (choice) {
                case 1:
                    new ViewAllFlightCommand().execute();
                    break;
                case 2:
                    new SearchFlightsByIDCommand().execute();
                    break;
                case 3:
                    new AddFlightCommand().execute();
                    break;
                case 4:
                    new EditFlightByIDCommand().execute();
                    break;
                case 5:
                    new DeleteFlightByIDCommand().execute();
                    break;
                case 6:
                    new ViewFlightSeatingChartCommand().execute();
                    break;
               case 7:
                   return true;
               default:
                   System.out.println("Invalid choice. Please try again.");
            }
            return false;
        }


        private static void printMenu() {
            System.out.println();
            System.out.println("===== Flight Management System =====");
            System.out.println("1. View All Flights");
            System.out.println("2. Search Flights Menu");
            System.out.println("3. Add Flight");
            System.out.println("4. Edit Flight by ID");
            System.out.println("5. Delete Flight by ID");
            System.out.println("6. View Flight Seating Chart by ID");
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

        public void display(){
            boolean flag = false;
            while(!flag) {
                Scanner scanner = new Scanner(System.in);
                printMenu();
                int choice = getUserChoice(scanner);
                flag = execute(choice);
            }
        }


    }
