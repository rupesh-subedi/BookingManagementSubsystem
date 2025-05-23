package bookingmanagement;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
//this is example of testing
public class BookingManagerTest {

    private BookingManager bookingManager;

    @BeforeEach
    public void setUp() {
        bookingManager = new BookingManager();
        System.out.println("Before each test: BookingManager initialized.");
    }

    @AfterEach
    public void tearDown() {
        bookingManager = null;
        System.out.println("After each test: BookingManager cleaned up.");
    }

    @Test
    public void testCreateBookingWithValidData() {
        Booking booking = bookingManager.createBooking("Alice", "Canada", false, false);
        assertEquals("Alice", booking.getCustomerName(), "Customer name should match");
    }

    @Test
    public void testCreateBookingWithNullCustomer() {
        Booking booking = bookingManager.createBooking(null, "USA", false, false);
        assertNull(booking.getCustomerName(), "Customer name should be null");
    }

    @Test
    public void testCancelBookingSuccess() {
        Booking booking = bookingManager.createBooking("Bob", "Australia", false, false);
        boolean isCancelled = bookingManager.cancelBooking(booking.getBookingId());
        assertTrue(isCancelled, "Booking should be cancelled successfully");
    }

    @Test
    public void testDifferentBookingsAreNotSame() {
        Booking b1 = bookingManager.createBooking("User1", "Nepal", false, false);
        Booking b2 = bookingManager.createBooking("User2", "USA", false, false);
        assertNotSame(b1, b2, "Two different bookings should not be the same object");
    }

    @Test
    public void testSeatAssignmentIsNotNull() {
        Booking booking = bookingManager.createBooking("Eve", "UK", false, false);
        assertNotNull(booking.getSeatNumber(), "Seat number should be auto-assigned and not null");
    }
}
