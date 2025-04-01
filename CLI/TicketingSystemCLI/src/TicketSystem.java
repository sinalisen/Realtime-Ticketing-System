import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class TicketSystem {
    public static void main(String[] args) throws InterruptedException {
        int totalTickets;
        int ticketReleaseRate;
        int customerRetrievalRate;
        int maxTicketCapacity;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter total tickets available: ");
        totalTickets = input.nextInt();

        System.out.println("Enter ticket release rate per ticket (How much tickets for a minute): ");
        ticketReleaseRate = input.nextInt();

        System.out.println("Enter customer retrieval rate per ticket (How much tickets for a minute): ");
        customerRetrievalRate = input.nextInt();

        System.out.println("Enter max ticket capacity: ");
        maxTicketCapacity = input.nextInt();

        System.out.println("System configuration completed!");
        input.nextLine(); // Consume the leftover newline

        TicketPool ticketPool = new TicketPool(maxTicketCapacity, totalTickets);

        // Corrected Vendor and Customer threads
        Thread vendor1 = new Thread(new Vendor(ticketPool, totalTickets, ticketReleaseRate, "Sinali", 2000, 7));
        Thread vendor2 = new Thread(new Vendor(ticketPool, totalTickets, ticketReleaseRate, "Dinali", 4000, 5));

        Thread customer1 = new Thread(new Customer(ticketPool, "tharindi", new Random().nextInt(customerRetrievalRate) + 1, 5, false));
        Thread customer2 = new Thread(new Customer(ticketPool, "navodi", new Random().nextInt(customerRetrievalRate) + 1, 3, false));
        Thread customer3 = new Thread(new Customer(ticketPool, "bihanga", new Random().nextInt(customerRetrievalRate) + 1, 4, true));

        vendor1.start();
        Thread.sleep(2000);
        vendor2.start();
        Thread.sleep(2000);
        customer1.start();
        Thread.sleep(2000);
        customer2.start();
        Thread.sleep(2000);
        customer3.start();
        Thread.sleep(2000);

        TicketSystem system = new TicketSystem();
        system.connection();
        system.runCLI();

        // Terminate the system when user enters "stop"
        while (true) {
            System.out.print("Enter 'stop' to terminate the system: ");
            String command = input.nextLine();
            if (command.equalsIgnoreCase("stop")) {
                System.out.println("Terminating the system...");
                System.exit(0);
            }
        }
    }

    public void runCLI() {
        System.out.println(
                "*********************************************\n" +
                        "WELCOME TO THE TICKET MANAGEMENT SYSTEM\n" +
                        "*********************************************\n" +
                        "\n" +
                        "Your one-stop solution for efficient event ticket tracking and management.\n" +
                        "\n" +
                        "\uD83D\uDE80 Features at your fingertips:\n" +
                        "   View the Events going to happen.\n" +
                        "   Purchase a Ticket.\n" +
                        "   Cancel your Ticket.\n" +
                        "   View Tickets you bought.\n" +
                        "   Contact with the Vendor.\n" +
                        "\n" +
                        "\uD83D\uDEE0️ Let's get started! Choose an option from the menu below.");
    }

    public void connection() {
        String url = "jdbc:mysql://localhost:3306/event_ticket_db";
        String user = "shone";
        String password = "abc@123";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM config_info");

            // Save data to a file
            try (FileWriter fileWriter = new FileWriter("config_info.txt")) {
                while (resultSet.next()) {
                    String configName = resultSet.getString("config_name");
                    String configParameter = resultSet.getString("config_parameter");

                    // Print to console
                    System.out.println("Config Name: " + configName);
                    System.out.println("Config Parameter: " + configParameter);

                    // Write to file
                    fileWriter.write("Config Name: " + configName + "\n");
                    fileWriter.write("Config Parameter: " + configParameter + "\n");
                }
                System.out.println("Data saved to config_info.txt.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Ensure the connection is closed properly
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}