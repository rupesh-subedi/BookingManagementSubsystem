package bookingmanagement;


import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBookingHandler implements Bookable {
    protected List<Booking> bookings = new ArrayList<>();
    protected List<Booking> bookingHistory = new ArrayList<>();

    public List<Booking> getBookings() {
        return bookings;
    }

    public List<Booking> getBookingHistory() {
        return bookingHistory;
    }
}

