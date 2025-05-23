package bookingmanagement;

public class CancelledState implements BookingState {
	public void handle(Booking booking) {
        booking.setDraft(false);
    }

    public String getStatus() {
        return "Cancelled";
    }
}
