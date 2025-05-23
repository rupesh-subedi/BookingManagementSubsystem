package bookingmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Backend {
	
	public static final List<String> DESTINATIONS = Arrays.asList("USA", "Canada", "Nepal", "Australia", "UK");

	

	 public List<Booking> bookings = new ArrayList<>();
	 // List to keep history of cancelled or old bookings
	 public List<Booking> bookingHistory = new ArrayList<>();
	 

	public void createBooking() {
		// TODO Auto-generated method stub

	}


	public void viewBooking() {
		// TODO Auto-generated method stub

	}


	public String updateBooking(Booking b,String name,String destination,boolean draftStatus,boolean proceedPMT) {
		 
	     
	         if (b.getCustomerName().equalsIgnoreCase(name)) {
	             
	             b.setDestination(destination);
	             b.setDraft(draftStatus);

	             // Prompt payment if booking is no longer draft and not paid yet
	             if (!b.isDraft() && !b.isPaid()) {
	                 b.setStatus("✅ Confirmed");
	                 return processPayment(proceedPMT,b);
	             }

	             return "✅ Booking updated.";
	             
	         }
	     
	     return "❌ Booking not found.";

	}

	// Helper to process payment for a booking
	 private String processPayment(boolean proceed,Booking booking) {
	   
	     if (proceed) {
	         booking.setPaid(true);
	         return "✅ Payment successful!";
	     } else {
	         booking.setPaid(false);
	         booking.setStatus("🕒 Pending");
	         return "⚠️ Payment skipped. Booking is pending.";
	     }
	 }
	

	public void cancelBooking() {
		// TODO Auto-generated method stub

	}


	public void searchBooking() {
		// TODO Auto-generated method stub

	}

	public void checkStatus() {
		// TODO Auto-generated method stub

	}


	public void viewBookingHistory() {
		// TODO Auto-generated method stub

	}

}
