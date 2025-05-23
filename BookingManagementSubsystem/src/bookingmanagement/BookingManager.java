package bookingmanagement;

import java.util.*;

public class BookingManager {
    private Map<String, Booking> bookings = new HashMap<>();
    private FlightManager flightManager;
    private static BookingManager instance;

    public BookingManager(FlightManager flightManager) {
        this.flightManager = flightManager;
    }

    public boolean createBooking(String customerName, String flightNumber, boolean isPaid, boolean isDraft) {
        if (customerName == null || customerName.isEmpty() || flightNumber == null || bookings.containsKey(customerName)) return false;
        Flight flight = flightManager.getFlight(flightNumber);
        if (flight == null || !flight.hasAvailableSeats()) return false;
        String destination = flight.getDestination();
        if (!isDraft) flight.bookSeat();  // Only count seat if confirmed
        bookings.put(customerName, new Booking(customerName, flightNumber, destination, isPaid, isDraft));
        return true;
    }

    public Booking viewBooking(String customerName) {
        return bookings.get(customerName);
    }

    public boolean cancelBooking(String customerName) {
        Booking booking = bookings.get(customerName);
        if (booking == null) return false;
        if (!booking.isDraft()) {
            Flight flight = flightManager.getFlight(booking.getFlightNumber());
            if (flight != null) flight.cancelSeat();
        }
        booking.cancelBooking();
        return true;
    }

    public boolean confirmDraft(String customerName) {
        Booking booking = bookings.get(customerName);
        if (booking == null || !booking.isDraft()) return false;
        Flight flight = flightManager.getFlight(booking.getFlightNumber());
        if (flight == null || !flight.hasAvailableSeats()) return false;
        flight.bookSeat();
        booking.confirmBooking();
        return true;
    }

    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings.values());
    }

    public void clearBookings() {
        bookings.clear();
    }

    public static BookingManager getInstance(FlightManager flightManager) {
        if (instance == null) {
            instance = new BookingManager(flightManager); // Inject dependency ONCE
        }
        return instance;
    }
}
