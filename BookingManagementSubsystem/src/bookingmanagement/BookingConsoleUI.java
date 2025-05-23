package bookingmanagement;


import bookingmanagement.Booking;
import bookingmanagement.BookingManager;

import java.util.List;
import java.util.Scanner;

public class BookingConsoleUI {
    private final BookingManager bookingManager;
    private final Scanner scanner;

    public BookingConsoleUI() {
        this.bookingManager = new BookingManager();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> handleCreateBooking();
                case 2 -> handleViewBookings();
                case 3 -> handleUpdateBooking();
                case 4 -> handleCancelBooking();
                case 5 -> handleSearchBooking();
                case 6 -> handleCheckStatus();
                case 7 -> handleBookingHistory();
                case 0 -> System.out.println("👋 Exiting Booking System. Goodbye!");
                default -> System.out.println("⚠️ Invalid option. Try again.");
            }
        } while (choice != 0);
    }

    private void showMenu() {
        System.out.println("""
                \n📘 Flight Booking System Menu:
                1️⃣ Create Booking 
                2️⃣ View All Booking
                3️⃣ Update Booking
                4️⃣ Cancel Booking
                5️⃣ Search Booking
                6️⃣ Check Booking Status
                7️⃣ View Booking History
                0️⃣ Exit
               
                ➤ Enter choice: \n""" );
    }

    private void handleCreateBooking() {
        System.out.print("👤 Enter customer name: ");
        String name = scanner.nextLine();
        System.out.println("🌍 Select destination: " + BookingManager.getAvailableDestinations());
        String destination = scanner.nextLine();

        System.out.print("📝 Save as draft? (true/false): ");
        boolean isDraft = Boolean.parseBoolean(scanner.nextLine());

        boolean promptForPayment = false;
        if (!isDraft) {
            System.out.print("💳 Proceed with payment? (true/false): ");
            promptForPayment = Boolean.parseBoolean(scanner.nextLine());
        }

        Booking booking = bookingManager.createBooking(name, destination, isDraft, promptForPayment);
        if (booking != null) {
            System.out.println("✅ Booking created:\n" + booking);
        } else {
            System.out.println("❌ Invalid destination.");
        }
    }

    private void handleViewBookings() {
        List<Booking> bookings = bookingManager.viewBookings();
        if (bookings.isEmpty()) {
            System.out.println("📭 No current bookings.");
        } else {
            bookings.forEach(System.out::println);
        }
    }

    private void handleUpdateBooking() {
        System.out.print("👤 Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("🌍 Enter new destination: ");
        String newDestination = scanner.nextLine();
        System.out.print("💳 Proceed with payment? (true/false): ");
        boolean pay = Boolean.parseBoolean(scanner.nextLine());

        if (bookingManager.updateBooking(name, newDestination, pay)) {
            System.out.println("✅ Booking updated.");
        } else {
            System.out.println("❌ Booking not found.");
        }
    }

    private void handleCancelBooking() {
        System.out.print("👤 Enter customer name: ");
        String name = scanner.nextLine();
        if (bookingManager.cancelBooking(name)) {
            System.out.println("❌ Booking cancelled.");
        } else {
            System.out.println("❌ Booking not found.");
        }
    }

    private void handleSearchBooking() {
        System.out.print("🔍 Enter customer name: ");
        String name = scanner.nextLine();
        Booking booking = bookingManager.searchBooking(name);
        if (booking != null) {
            System.out.println("✅ Booking found:\n" + booking);
        } else {
            System.out.println("❌ Booking not found.");
        }
    }

    private void handleCheckStatus() {
        System.out.print("👤 Enter customer name: ");
        String name = scanner.nextLine();
        String status = bookingManager.checkStatus(name);
        System.out.println("📌 Status: " + status);
    }

    private void handleBookingHistory() {
        List<Booking> history = bookingManager.viewBookingHistory();
        if (history.isEmpty()) {
            System.out.println("📭 No booking history.");
        } else {
            history.forEach(System.out::println);
        }
    }
}

