package com.keyin.cli.menus;

import java.util.Scanner;

public class MenuDirectory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    optionOne();
                    break;
                case 2:
                    optionTwo();
                    break;
                case 3:
                    optionThree();
                    break;
                case 4:
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
        System.out.println("===== Main Menu =====");
        System.out.println("1. Option 1");
        System.out.println("2. Option 2");
        System.out.println("3. Option 3");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
            System.out.print("Choose an option: ");
        }
        return scanner.nextInt();
    }

    private static void optionOne() {
        System.out.println("You chose Option 1");
        // Add functionality for Option 1
    }

    private static void optionTwo() {
        System.out.println("You chose Option 2");
        // Add functionality for Option 2
    }

    private static void optionThree() {
        System.out.println("You chose Option 3");
        // Add functionality for Option 3
    }
}

