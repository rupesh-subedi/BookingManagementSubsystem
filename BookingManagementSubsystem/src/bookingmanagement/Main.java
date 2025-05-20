package bookingmanagement;
import java.util.Scanner;

//Main driver class with user menu and interaction loop
public class Main {
 public static void main(String[] args) {
     BookingManager manager = new BookingManager();  // Booking operations handler
     Scanner scanner = new Scanner(System.in);
     int choice;

     do {
         // Display menu with emojis for friendliness
         System.out.println("\n===== ✈️ Flight Booking System ✈️ =====");
         System.out.println("1️⃣ Create Booking");
         System.out.println("2️⃣ View Booking");
         System.out.println("3️⃣ Update Booking");
         System.out.println("4️⃣ Cancel Booking");
         System.out.println("5️⃣ Search Booking");
         System.out.println("6️⃣ Check Booking Status");
         System.out.println("7️⃣ View Booking History");
         System.out.println("0️⃣ Exit");
         System.out.print("➡️ Enter choice: ");
         choice = scanner.nextInt();
         scanner.nextLine(); // Consume newline

         // Switch case to call appropriate method
         switch (choice) {
             case 1 -> manager.createBooking();
             case 2 -> manager.viewBooking();
             case 3 -> manager.updateBooking();
             case 4 -> manager.cancelBooking();
             case 5 -> manager.searchBooking();
             case 6 -> manager.checkStatus();
             case 7 -> manager.viewBookingHistory();
             case 0 -> System.out.println("👋 Thank you for using Flight Booking System!");
             default -> System.out.println("❌ Invalid choice. Try again.");
         }
     } while (choice != 0);

     scanner.close();  // Close scanner resource
 }
}
