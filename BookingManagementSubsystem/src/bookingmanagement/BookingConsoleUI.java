package bookingmanagement;

import java.util.Scanner;

public class BookingConsoleUI {
    private BookingManager bookingManager;
    private Scanner scanner = new Scanner(System.in);

    public BookingConsoleUI(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    public void start() {
        while (true) {
            System.out.println("\n📘 ✈️ Booking System ✈️");
            System.out.println("1. Create Booking");
            System.out.println("2. View Booking");
            System.out.println("3. Confirm Draft Booking");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit to Main Menu");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createBooking();
                case 2 -> viewBooking();
                case 3 -> confirmDraft();
                case 4 -> cancelBooking();
                case 5 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void createBooking() {
        System.out.print("Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Flight Number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Paid (true/false): ");
        boolean isPaid = scanner.nextBoolean();
        System.out.print("Save as draft? (true/false): ");
        boolean isDraft = scanner.nextBoolean();
        scanner.nextLine();

        if (bookingManager.createBooking(name, flightNumber, isPaid, isDraft)) {
            System.out.println("Booking " + (isDraft ? "saved as draft." : "confirmed.") );
        } else {
            System.out.println("Booking failed.");
        }
    }

    private void viewBooking() {
        System.out.print("Customer Name: ");
        String name = scanner.nextLine();
        Booking booking = bookingManager.viewBooking(name);
        if (booking != null) {
            System.out.println("Flight: " + booking.getFlightNumber());
            System.out.println("Destination: " + booking.getDestination());
            System.out.println("Status: " + booking.getStatus());
            System.out.println("Paid: " + booking.isPaid());
            System.out.println("Draft: " + booking.isDraft());
        } else {
            System.out.println("Booking not found.");
        }
    }

    private void confirmDraft() {
        System.out.print("Customer Name: ");
        String name = scanner.nextLine();
        if (bookingManager.confirmDraft(name)) {
            System.out.println("Draft booking confirmed.");
        } else {
            System.out.println("Unable to confirm booking.");
        }
    }

    private void cancelBooking() {
        System.out.print("Customer Name: ");
        String name = scanner.nextLine();
        if (bookingManager.cancelBooking(name)) {
            System.out.println("Booking cancelled.");
        } else {
            System.out.println("Booking not found.");
        }
    }
}
