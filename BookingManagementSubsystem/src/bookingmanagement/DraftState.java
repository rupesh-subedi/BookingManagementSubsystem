package bookingmanagement;

public class DraftState implements BookingState {
	public void handle(Booking booking) {
        booking.setDraft(true);
    }

    public String getStatus() {
        return "Draft";
    }
}
