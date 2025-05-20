package bookingmanagement;
//Model class representing a flight booking
public class Booking {
 private String customerName;   // Customer name (identifier)
 private String destination;    // Destination selected from predefined list
 private boolean isDraft;       // Flag for draft booking status
 private boolean isPaid;        // Flag to check if booking is paid
 private String status;         // Status: Pending, Confirmed, Cancelled, Draft
 private String seatNumber;     // Automatically assigned seat number

 // Constructor initializes customer name, destination, draft status, sets default status as Pending
 public Booking(String customerName, String destination, boolean isDraft) {
     this.customerName = customerName;
     this.destination = destination;
     this.isDraft = isDraft;
     this.status = "🕒 Pending";
 }

 // Getters and setters for all fields
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

 // To string method to nicely display booking info with emojis
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
}
