package bookingmanagement;

public class Booking {
    private String customerName;
    private String destination;
    private boolean isDraft;
    private boolean isPaid;
    private String status;
    private String seatNumber;

    public Booking(String customerName, String destination, boolean isDraft) {
        this.customerName = customerName;
        this.destination = destination;
        this.isDraft = isDraft;
        this.status = "🕒 Pending";
    }

    public String getCustomerName() { return customerName; }
    public String getDestination() { return destination; }
    public boolean isDraft() { return isDraft; }
    public boolean isPaid() { return isPaid; }
    public String getStatus() { return status; }
    public String getSeatNumber() { return seatNumber; }

    public void setDestination(String destination) { this.destination = destination; }
    public void setDraft(boolean draft) { isDraft = draft; }
    public void setPaid(boolean paid) { isPaid = paid; }
    public void setStatus(String status) { this.status = status; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    @Override
    public String toString() {
        return "📄 Booking{" +
                "👤 Name='" + customerName + '\'' +
                ", 🌍 Destination='" + destination + '\'' +
                ", 💺 Seat='" + seatNumber + '\'' +
                ", 📝 Draft=" + isDraft +
                ", 💳 Paid=" + isPaid +
                ", 📌 Status='" + status + '\'' +
                '}';
    }

	public String getBookingId() {
		// TODO Auto-generated method stub
		return null;
	}
}
