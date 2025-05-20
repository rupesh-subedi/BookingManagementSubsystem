package bookingmanagement;
import java.util.*;

//BookingManager implements all booking-related operations and extends abstract handler
public class BookingManager extends AbstractBookingHandler {
 // Predefined list of allowed destinations
 private static final List<String> DESTINATIONS = Arrays.asList("USA", "Canada", "Nepal", "Australia", "UK");
 private Random random = new Random();  // Random for seat assignment

 // Create a new booking with name, destination, draft status, auto seat, payment prompt
 @Override
 public void createBooking() {
     Scanner scanner = new Scanner(System.in);

     System.out.print("👤 Enter customer name: ");
     String name = scanner.nextLine();

     // Show destinations for user to select
     System.out.println("🌍 Choose destination:");
     for (int i = 0; i < DESTINATIONS.size(); i++) {
         System.out.println((i + 1) + ". " + DESTINATIONS.get(i));
     }

     int destChoice = scanner.nextInt();
     scanner.nextLine(); // consume newline
     if (destChoice < 1 || destChoice > DESTINATIONS.size()) {
         System.out.println("❌ Invalid destination.");
         return;
     }
     String destination = DESTINATIONS.get(destChoice - 1);

     System.out.print("📝 Is this a draft booking? (yes/no): ");
     boolean isDraft = scanner.nextLine().equalsIgnoreCase("yes");

     // Create booking object
     Booking booking = new Booking(name, destination, isDraft);
     // Auto-assign seat number
     booking.setSeatNumber("S" + (100 + random.nextInt(900)));

     // If not draft, prompt payment
     if (!isDraft) {
         processPayment(scanner, booking);
         booking.setStatus("✅ Confirmed");
     } else {
         booking.setStatus("📝 Draft");
     }

     bookings.add(booking);  // Add booking to active list
     System.out.println("🎉 Booking created successfully!");
     System.out.println(booking);
 }

 // View booking by customer name
 @Override
 public void viewBooking() {
     Scanner scanner = new Scanner(System.in);
     System.out.print("👤 Enter your name to view booking: ");
     String name = scanner.nextLine();

     for (Booking b : bookings) {
         if (b.getCustomerName().equalsIgnoreCase(name)) {
             System.out.println(b);
             return;
         }
     }
     System.out.println("❌ Booking not found.");
 }

 // Update booking destination and draft/payment status
 @Override
 public void updateBooking() {
     Scanner scanner = new Scanner(System.in);
     System.out.print("👤 Enter your name to update booking: ");
     String name = scanner.nextLine();

     for (Booking b : bookings) {
         if (b.getCustomerName().equalsIgnoreCase(name)) {
             System.out.print("🌍 Enter new destination: ");
             b.setDestination(scanner.nextLine());

             System.out.print("📝 Is it still a draft? (yes/no): ");
             b.setDraft(scanner.nextLine().equalsIgnoreCase("yes"));

             // Prompt payment if booking is no longer draft and not paid yet
             if (!b.isDraft() && !b.isPaid()) {
                 processPayment(scanner, b);
                 b.setStatus("✅ Confirmed");
             }

             System.out.println("✅ Booking updated.");
             return;
         }
     }
     System.out.println("❌ Booking not found.");
 }

 // Cancel booking by name and move it to history
 @Override
 public void cancelBooking() {
     Scanner scanner = new Scanner(System.in);
     System.out.print("👤 Enter your name to cancel booking: ");
     String name = scanner.nextLine();

     Iterator<Booking> iterator = bookings.iterator();
     while (iterator.hasNext()) {
         Booking b = iterator.next();
         if (b.getCustomerName().equalsIgnoreCase(name)) {
             iterator.remove();
             b.setStatus("❌ Cancelled");
             bookingHistory.add(b);
             System.out.println("🗑️ Booking cancelled.");
             return;
         }
     }
     System.out.println("❌ Booking not found.");
 }

 // Search bookings by name and display all matches
 @Override
 public void searchBooking() {
     Scanner scanner = new Scanner(System.in);
     System.out.print("🔎 Enter name to search: ");
     String name = scanner.nextLine();

     boolean found = false;
     for (Booking b : bookings) {
         if (b.getCustomerName().equalsIgnoreCase(name)) {
             System.out.println(b);
             found = true;
         }
     }
     if (!found) System.out.println("❌ No bookings found.");
 }

 // Check booking status by name
 @Override
 public void checkStatus() {
     Scanner scanner = new Scanner(System.in);
     System.out.print("👤 Enter your name to check status: ");
     String name = scanner.nextLine();

     for (Booking b : bookings) {
         if (b.getCustomerName().equalsIgnoreCase(name)) {
             System.out.println("📌 Status: " + b.getStatus());
             return;
         }
     }
     System.out.println("❌ Booking not found.");
 }

 // Show all bookings in history (cancelled or old)
 @Override
 public void viewBookingHistory() {
     if (bookingHistory.isEmpty()) {
         System.out.println("📭 No history yet.");
     } else {
         for (Booking b : bookingHistory) {
             System.out.println(b);
         }
     }
 }

 // Helper to process payment for a booking
 private void processPayment(Scanner scanner, Booking booking) {
     System.out.print("💳 Proceed with payment? (yes/no): ");
     if (scanner.nextLine().equalsIgnoreCase("yes")) {
         booking.setPaid(true);
         System.out.println("✅ Payment successful!");
     } else {
         booking.setPaid(false);
         booking.setStatus("🕒 Pending");
         System.out.println("⚠️ Payment skipped. Booking is pending.");
     }
 }
}

