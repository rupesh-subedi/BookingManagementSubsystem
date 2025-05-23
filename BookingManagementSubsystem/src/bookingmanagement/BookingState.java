package bookingmanagement;

public interface BookingState {
	void handle(Booking booking);
    String getStatus();
}
