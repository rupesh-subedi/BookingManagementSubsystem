package bookingmanagement;


public class Booking {
    private String customerName;
    private String flightNumber;
    private String destination;
    private boolean isPaid;
    private String status; // e.g., Confirmed, Cancelled
    private boolean isDraft;
    private BookingState state;

    public Booking(String customerName, String flightNumber, String destination, boolean isPaid, boolean isDraft) {
        this.customerName = customerName;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.isPaid = isPaid;
        this.isDraft = isDraft;
//        this.status = isDraft ? "Draft" : "Confirmed";
        setState(isDraft ? new DraftState() : new ConfirmedState());
    }
    public void setState(BookingState state) {
        this.state = state;
        this.state.handle(this);
    }
    public BookingState getState() { return state; }

    public String getCustomerName() { return customerName; }
    public String getFlightNumber() { return flightNumber; }
    public String getDestination() { return destination; }
    public boolean isPaid() { return isPaid; }
    public boolean isDraft() {
        return state instanceof DraftState;
    }
//    public String getStatus() { return status; }
//    public boolean isDraft() { return isDraft; }
    public void setDraft(boolean draft) { this.isDraft = draft; }
    public void confirmBooking() { setState(new ConfirmedState()); }
    public String getStatus() { return state.getStatus(); }
    public void cancelBooking() { setState(new CancelledState()); }


//    public void confirmBooking() {
//        this.isDraft = false;
//        this.status = "Confirmed";
//    }

//    public void cancelBooking() {
//        this.status = "Cancelled";
//    }

    public void setPaid(boolean paid) { isPaid = paid; }
}
