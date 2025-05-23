package bookingmanagement;


import java.util.*;

public class FlightManager {
    private Map<String, Flight> flights = new HashMap<>();

    public boolean addFlight(String flightNumber, String origin, String destination, int capacity) {
        if (flightNumber == null || flightNumber.isEmpty() || flights.containsKey(flightNumber)) return false;
        flights.put(flightNumber, new Flight(flightNumber, origin, destination, capacity));
        return true;
    }

    public Flight getFlight(String flightNumber) {
        return flights.get(flightNumber);
    }

    public boolean removeFlight(String flightNumber) {
        return flights.remove(flightNumber) != null;
    }

    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights.values());
    }
}
