package bookingmanagement;
import java.util.List;
//Interface declaring basic booking operations


public interface Bookable {
    void createBooking();
    void viewBooking();
    void updateBooking();
    void cancelBooking();
    void searchBooking();
    void checkStatus();
//    void viewBookingHistory();/
    //List<Booking> viewBookingHistory();  // <-- updated return type
}

