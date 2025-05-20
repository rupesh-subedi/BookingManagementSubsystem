package bookingmanagement;
import java.util.ArrayList;
import java.util.List;

// Abstract base class providing shared booking data and common method(s)
public abstract class AbstractBookingHandler implements Bookable {
    // List to hold active bookings
    protected List<Booking> bookings = new ArrayList<>();
    // List to keep history of cancelled or old bookings
    protected List<Booking> bookingHistory = new ArrayList<>();

    // Utility method to print all active bookings
    public void printAllBookings() {
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }
}
