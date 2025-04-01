package TicketingSystemCLI;

import java.util.Scanner;

public class SystemConfiguration {
    private static final int MIN_TICKETS = 1;
    private static final int MAX_TICKETS = 10000;

    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Event Ticketing System Configuration ===");

        // Total Tickets Configuration
        while (true) {
            System.out.print("Enter total number of tickets (1-10000): ");
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= MIN_TICKETS && input <= MAX_TICKETS) {
                    this.totalTickets = input;
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 10000.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Ticket Release Rate Configuration
        while (true) {
            System.out.print("Enter ticket release rate per minute (1-100): ");
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input > 0 && input <= 100) {
                    this.ticketReleaseRate = input;
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Add similar validation for customer retrieval rate and max ticket capacity

        // Save configuration
        saveConfiguration();
    }

    private void saveConfiguration() {
        // In a real implementation, this would save to a JSON or properties file
        System.out.println("\n=== Configuration Summary ===");
        System.out.println("Total Tickets: " + totalTickets);
        System.out.println("Ticket Release Rate: " + ticketReleaseRate + " per minute");

        // Option to save to a configuration file or send to backend
    }

    public static void main(String[] args) {
         SystemConfiguration cli = new SystemConfiguration();
        cli.start();
    }


}