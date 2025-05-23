package bookingmanagement;


import java.util.*;

public class BookingManager extends AbstractBookingHandler {
    private static final String[] DESTINATIONS = {"USA", "Canada", "Nepal", "Australia", "UK"};
    private final Random random = new Random();

    public Booking createBooking(String customerName, String destination, boolean isDraft, boolean promptForPayment) {
        if (!Arrays.asList(DESTINATIONS).contains(destination)) {
            return null;
        }
        Booking booking = new Booking(customerName, destination, isDraft);
        if (!isDraft && promptForPayment) {
            booking.setPaid(true);
            booking.setStatus("✅ Confirmed");
        }
        booking.setSeatNumber(assignSeat());
        bookings.add(booking);
        bookingHistory.add(booking);
        return booking;
    }

    public List<Booking> viewBookings() {
        return new ArrayList<>(bookings);
    }

    public boolean updateBooking(String customerName, String newDestination, boolean promptForPayment) {
        for (Booking booking : bookings) {
            if (booking.getCustomerName().equalsIgnoreCase(customerName)) {
                booking.setDestination(newDestination);
                if (!booking.isDraft() && promptForPayment) {
                    booking.setPaid(true);
                    booking.setStatus("✅ Confirmed");
                }
                return true;
            }
        }
        return false;
    }

    public boolean cancelBooking(String customerName) {
        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.getCustomerName().equalsIgnoreCase(customerName)) {
                iterator.remove();
                booking.setStatus("❌ Cancelled");
                bookingHistory.add(booking);
                return true;
            }
        }
        return false;
    }

    public Booking searchBooking(String customerName) {
        for (Booking booking : bookings) {
            if (booking.getCustomerName().equalsIgnoreCase(customerName)) {
                return booking;
            }
        }
        return null;
    }

    public String checkStatus(String customerName) {
        for (Booking booking : bookings) {
            if (booking.getCustomerName().equalsIgnoreCase(customerName)) {
                return booking.getStatus();
            }
        }
        return "❓ Not Found";
    }

    public List<Booking> viewBookingHistory() {
        return new ArrayList<>(bookingHistory);
    }

    public static List<String> getAvailableDestinations() {
        return Arrays.asList(DESTINATIONS);
    }

    private String assignSeat() {
        int row = random.nextInt(30) + 1;
        char seat = (char) ('A' + random.nextInt(6));
        return row + String.valueOf(seat);
    }

	@Override
	public void createBooking() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewBooking() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBooking() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelBooking() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchBooking() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkStatus() {
		// TODO Auto-generated method stub
		
	}
}
