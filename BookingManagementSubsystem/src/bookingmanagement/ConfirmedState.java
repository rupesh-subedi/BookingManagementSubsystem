package bookingmanagement;

public class ConfirmedState implements BookingState {
	public void handle(Booking booking) {
        booking.setDraft(false);
    }

    public String getStatus() {
        return "Confirmed";
    }
}
