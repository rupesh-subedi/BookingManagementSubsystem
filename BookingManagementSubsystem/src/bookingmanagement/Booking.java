package bookingmanagement;


public class Booking {
    private String customerName;
    private String flightNumber;
    private String destination;
    private boolean isPaid;
    private String status; // e.g., Confirmed, Cancelled
    private boolean isDraft;

    public Booking(String customerName, String flightNumber, String destination, boolean isPaid, boolean isDraft) {
        this.customerName = customerName;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.isPaid = isPaid;
        this.isDraft = isDraft;
        this.status = isDraft ? "Draft" : "Confirmed";
    }

    public String getCustomerName() { return customerName; }
    public String getFlightNumber() { return flightNumber; }
    public String getDestination() { return destination; }
    public boolean isPaid() { return isPaid; }
    public String getStatus() { return status; }
    public boolean isDraft() { return isDraft; }

    public void confirmBooking() {
        this.isDraft = false;
        this.status = "Confirmed";
    }

    public void cancelBooking() {
        this.status = "Cancelled";
    }

    public void setPaid(boolean paid) { isPaid = paid; }
}
