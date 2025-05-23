package bookingmanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlightManager flightManager = new FlightManager();
        BookingManager bookingManager = new BookingManager(flightManager);
        FlightConsoleUI flightUI = new FlightConsoleUI(flightManager);
        BookingConsoleUI bookingUI = new BookingConsoleUI(bookingManager);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n🌐 === Welcome to Flight Booking System ===");
            System.out.println("1️⃣ Manage Flights");
            System.out.println("2️⃣ Manage Bookings");
            System.out.println("3️⃣ Exit Program");
            System.out.print("🔸 Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> flightUI.start();
                case 2 -> bookingUI.start();
                case 3 -> {
                    System.out.println("👋 Exiting system. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("❌ Invalid choice. Please enter 1, 2 or 3.");
            }
        }
    }
}
