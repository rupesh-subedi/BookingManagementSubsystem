package bookingmanagement;

//Interface declaring basic booking operations
public interface Bookable {
 void createBooking();      // Create a new booking
 void viewBooking();        // View existing booking details
 void updateBooking();      // Update booking information
 void cancelBooking();      // Cancel a booking
 void searchBooking();      // Search bookings by customer name
 void checkStatus();        // Check booking status
 void viewBookingHistory(); // View past/cancelled booking history
}
