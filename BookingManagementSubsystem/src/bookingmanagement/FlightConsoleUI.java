package bookingmanagement;


import java.util.List;
import java.util.Scanner;

public class FlightConsoleUI {
    private FlightManager flightManager;
    private Scanner scanner = new Scanner(System.in);

    public FlightConsoleUI(FlightManager flightManager) {
        this.flightManager = flightManager;
    }

    public void start() {
        while (true) {
            System.out.println("\n🛫 === Flight Management Menu ===");
            System.out.println("1️⃣ Add New Flight");
            System.out.println("2️⃣ View Flight Details");
            System.out.println("3️⃣ List All Flights");
            System.out.println("4️⃣ Remove Flight");
            System.out.println("5️⃣ Exit to Main Menu");
            System.out.print("🔸 Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1 -> addFlight();
                case 2 -> viewFlight();
                case 3 -> listFlights();
                case 4 -> removeFlight();
                case 5 -> { return; }
                default -> System.out.println("❌ Invalid option. Please try again.");
            }
        }
    }

    private void addFlight() {
        System.out.println("➕ Add New Flight:");
        System.out.print("🆔 Flight Number: ");
        String fn = scanner.nextLine();
        System.out.print("🌍 Origin: ");
        String origin = scanner.nextLine();
        System.out.print("📍 Destination: ");
        String dest = scanner.nextLine();
        System.out.print("👥 Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        if (flightManager.addFlight(fn, origin, dest, capacity)) {
            System.out.println("✅ Flight added successfully!");
        } else {
            System.out.println("⚠️ Flight already exists or invalid input.");
        }
    }

    private void viewFlight() {
        System.out.print("🔍 Enter Flight Number: ");
        String fn = scanner.nextLine();
        Flight flight = flightManager.getFlight(fn);
        if (flight != null) {
            System.out.println("\n📄 Flight Details:");
            System.out.println("✈️ Flight: " + flight.getFlightNumber());
            System.out.println("🌍 From: " + flight.getOrigin());
            System.out.println("📍 To: " + flight.getDestination());
            System.out.println("👥 Capacity: " + flight.getCapacity());
            System.out.println("🧍‍♂️ Booked Seats: " + flight.getBookedSeats());
            System.out.println("🟢 Available Seats: " + (flight.getCapacity() - flight.getBookedSeats()));
        } else {
            System.out.println("❌ Flight not found.");
        }
    }

    private void listFlights() {
        List<Flight> flights = flightManager.getAllFlights();
        if (flights.isEmpty()) {
            System.out.println("📭 No flights available.");
        } else {
            System.out.println("📋 All Flights:");
            for (Flight f : flights) {
                System.out.printf("✈️ %s: %s ➝ %s | Capacity: %d | Booked: %d | Available: %d\n",
                        f.getFlightNumber(), f.getOrigin(), f.getDestination(), f.getCapacity(), f.getBookedSeats(), f.getCapacity() - f.getBookedSeats());
            }
        }
    }

    private void removeFlight() {
        System.out.print("❌ Enter Flight Number to remove: ");
        String fn = scanner.nextLine();
        if (flightManager.removeFlight(fn)) {
            System.out.println("✅ Flight removed.");
        } else {
            System.out.println("❌ Flight not found.");
        }
    }
}
