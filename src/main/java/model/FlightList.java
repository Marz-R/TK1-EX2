package model;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FlightList {
	private List<Flight> flights = new ArrayList<Flight>();
	// private List<Transaction> transactions;  // list of transactions contains data: clientID, flight, seat, meal, and paid amount
	
	public FlightList() {
		setUpFlights();
	}
	
	// instantiate all flights (9 flights * 7 days)
 	private void setUpFlights() {
	    flights.add(new Flight("TK0001", "FRA", DayOfWeek.MONDAY, LocalTime.parse("08:20:00"), "Embraer E170", 50));
	    flights.add(new Flight("TK0002", "AAH", DayOfWeek.MONDAY, LocalTime.parse("12:40:00"), "Embraer E170", 100));
	    flights.add(new Flight("TK0003", "BER", DayOfWeek.MONDAY, LocalTime.parse("22:00:00"), "Embraer E170", 200));
	    flights.add(new Flight("TK0004", "IST", DayOfWeek.MONDAY, LocalTime.parse("10:15:00"), "Airbus 319", 100));
	    flights.add(new Flight("TK0005", "CDG", DayOfWeek.MONDAY, LocalTime.parse("15:30:00"), "Airbus 319", 200));
	    flights.add(new Flight("TK0006", "LHR", DayOfWeek.MONDAY, LocalTime.parse("19:50:00"), "Airbus 319", 300));
	    flights.add(new Flight("TK0007", "CAN", DayOfWeek.MONDAY, LocalTime.parse("07:10:00"), "Boeing 737-900", 150));
	    flights.add(new Flight("TK0008", "ATL", DayOfWeek.MONDAY, LocalTime.parse("13:25:00"), "Boeing 737-900", 250));
	    flights.add(new Flight("TK0009", "HND", DayOfWeek.MONDAY, LocalTime.parse("21:45:00"), "Boeing 737-900", 350));

	    flights.add(new Flight("TK0010", "FRA", DayOfWeek.TUESDAY, LocalTime.parse("08:20:00"), "Embraer E170", 50));
	    flights.add(new Flight("TK0011", "AAH", DayOfWeek.TUESDAY, LocalTime.parse("12:40:00"), "Embraer E170", 100));
	    flights.add(new Flight("TK0012", "BER", DayOfWeek.TUESDAY, LocalTime.parse("22:00:00"), "Embraer E170", 200));
	    flights.add(new Flight("TK0013", "IST", DayOfWeek.TUESDAY, LocalTime.parse("10:15:00"), "Airbus 319", 100));
	    flights.add(new Flight("TK0014", "CDG", DayOfWeek.TUESDAY, LocalTime.parse("15:30:00"), "Airbus 319", 200));
	    flights.add(new Flight("TK0015", "LHR", DayOfWeek.TUESDAY, LocalTime.parse("19:50:00"), "Airbus 319", 300));
	    flights.add(new Flight("TK0016", "CAN", DayOfWeek.TUESDAY, LocalTime.parse("07:10:00"), "Boeing 737-900", 150));
	    flights.add(new Flight("TK0017", "ATL", DayOfWeek.TUESDAY, LocalTime.parse("13:25:00"), "Boeing 737-900", 250));
	    flights.add(new Flight("TK0018", "HND", DayOfWeek.TUESDAY, LocalTime.parse("21:45:00"), "Boeing 737-900", 350));

	    flights.add(new Flight("TK0019", "FRA", DayOfWeek.WEDNESDAY, LocalTime.parse("08:20:00"), "Embraer E170", 50));
	    flights.add(new Flight("TK0020", "AAH", DayOfWeek.WEDNESDAY, LocalTime.parse("12:40:00"), "Embraer E170", 100));
	    flights.add(new Flight("TK0021", "BER", DayOfWeek.WEDNESDAY, LocalTime.parse("22:00:00"), "Embraer E170", 200));
	    flights.add(new Flight("TK0022", "IST", DayOfWeek.WEDNESDAY, LocalTime.parse("10:15:00"), "Airbus 319", 100));
	    flights.add(new Flight("TK0023", "CDG", DayOfWeek.WEDNESDAY, LocalTime.parse("15:30:00"), "Airbus 319", 200));
	    flights.add(new Flight("TK0024", "LHR", DayOfWeek.WEDNESDAY, LocalTime.parse("19:50:00"), "Airbus 319", 300));
	    flights.add(new Flight("TK0025", "CAN", DayOfWeek.WEDNESDAY, LocalTime.parse("07:10:00"), "Boeing 737-900", 150));
	    flights.add(new Flight("TK0026", "ATL", DayOfWeek.WEDNESDAY, LocalTime.parse("13:25:00"), "Boeing 737-900", 250));
	    flights.add(new Flight("TK0027", "HND", DayOfWeek.WEDNESDAY, LocalTime.parse("21:45:00"), "Boeing 737-900", 350));

	    flights.add(new Flight("TK0028", "FRA", DayOfWeek.THURSDAY, LocalTime.parse("08:20:00"), "Embraer E170", 50));
	    flights.add(new Flight("TK0029", "AAH", DayOfWeek.THURSDAY, LocalTime.parse("12:40:00"), "Embraer E170", 100));
	    flights.add(new Flight("TK0030", "BER", DayOfWeek.THURSDAY, LocalTime.parse("22:00:00"), "Embraer E170", 200));
	    flights.add(new Flight("TK0031", "IST", DayOfWeek.THURSDAY, LocalTime.parse("10:15:00"), "Airbus 319", 100));
	    flights.add(new Flight("TK0032", "CDG", DayOfWeek.THURSDAY, LocalTime.parse("15:30:00"), "Airbus 319", 200));
	    flights.add(new Flight("TK0033", "LHR", DayOfWeek.THURSDAY, LocalTime.parse("19:50:00"), "Airbus 319", 300));
	    flights.add(new Flight("TK0034", "CAN", DayOfWeek.THURSDAY, LocalTime.parse("07:10:00"), "Boeing 737-900", 150));
	    flights.add(new Flight("TK0035", "ATL", DayOfWeek.THURSDAY, LocalTime.parse("13:25:00"), "Boeing 737-900", 250));
	    flights.add(new Flight("TK0036", "HND", DayOfWeek.THURSDAY, LocalTime.parse("21:45:00"), "Boeing 737-900", 350));

	    flights.add(new Flight("TK0037", "FRA", DayOfWeek.FRIDAY, LocalTime.parse("08:20:00"), "Embraer E170", 50));
	    flights.add(new Flight("TK0038", "AAH", DayOfWeek.FRIDAY, LocalTime.parse("12:40:00"), "Embraer E170", 100));
	    flights.add(new Flight("TK0039", "BER", DayOfWeek.FRIDAY, LocalTime.parse("22:00:00"), "Embraer E170", 200));
	    flights.add(new Flight("TK0040", "IST", DayOfWeek.FRIDAY, LocalTime.parse("10:15:00"), "Airbus 319", 100));
	    flights.add(new Flight("TK0041", "CDG", DayOfWeek.FRIDAY, LocalTime.parse("15:30:00"), "Airbus 319", 200));
	    flights.add(new Flight("TK0042", "LHR", DayOfWeek.FRIDAY, LocalTime.parse("19:50:00"), "Airbus 319", 300));
	    flights.add(new Flight("TK0043", "CAN", DayOfWeek.FRIDAY, LocalTime.parse("07:10:00"), "Boeing 737-900", 150));
	    flights.add(new Flight("TK0044", "ATL", DayOfWeek.FRIDAY, LocalTime.parse("13:25:00"), "Boeing 737-900", 250));
	    flights.add(new Flight("TK0045", "HND", DayOfWeek.FRIDAY, LocalTime.parse("21:45:00"), "Boeing 737-900", 350));

	    flights.add(new Flight("TK0046", "FRA", DayOfWeek.SATURDAY, LocalTime.parse("08:20:00"), "Embraer E170", 50));
	    flights.add(new Flight("TK0047", "AAH", DayOfWeek.SATURDAY, LocalTime.parse("12:40:00"), "Embraer E170", 100));
	    flights.add(new Flight("TK0048", "BER", DayOfWeek.SATURDAY, LocalTime.parse("22:00:00"), "Embraer E170", 200));
	    flights.add(new Flight("TK0049", "IST", DayOfWeek.SATURDAY, LocalTime.parse("10:15:00"), "Airbus 319", 100));
	    flights.add(new Flight("TK0050", "CDG", DayOfWeek.SATURDAY, LocalTime.parse("15:30:00"), "Airbus 319", 200));
	    flights.add(new Flight("TK0051", "LHR", DayOfWeek.SATURDAY, LocalTime.parse("19:50:00"), "Airbus 319", 300));
	    flights.add(new Flight("TK0052", "CAN", DayOfWeek.SATURDAY, LocalTime.parse("07:10:00"), "Boeing 737-900", 150));
	    flights.add(new Flight("TK0053", "ATL", DayOfWeek.SATURDAY, LocalTime.parse("13:25:00"), "Boeing 737-900", 250));
	    flights.add(new Flight("TK0054", "HND", DayOfWeek.SATURDAY, LocalTime.parse("21:45:00"), "Boeing 737-900", 350));

	    flights.add(new Flight("TK0055", "FRA", DayOfWeek.SUNDAY, LocalTime.parse("08:20:00"), "Embraer E170", 50));
	    flights.add(new Flight("TK0056", "AAH", DayOfWeek.SUNDAY, LocalTime.parse("12:40:00"), "Embraer E170", 100));
	    flights.add(new Flight("TK0057", "BER", DayOfWeek.SUNDAY, LocalTime.parse("22:00:00"), "Embraer E170", 200));
	    flights.add(new Flight("TK0058", "IST", DayOfWeek.SUNDAY, LocalTime.parse("10:15:00"), "Airbus 319", 100));
	    flights.add(new Flight("TK0059", "CDG", DayOfWeek.SUNDAY, LocalTime.parse("15:30:00"), "Airbus 319", 200));
	    flights.add(new Flight("TK0060", "LHR", DayOfWeek.SUNDAY, LocalTime.parse("19:50:00"), "Airbus 319", 300));
	    flights.add(new Flight("TK0061", "CAN", DayOfWeek.SUNDAY, LocalTime.parse("07:10:00"), "Boeing 737-900", 150));
	    flights.add(new Flight("TK0062", "ATL", DayOfWeek.SUNDAY, LocalTime.parse("13:25:00"), "Boeing 737-900", 250));
	    flights.add(new Flight("TK0063", "HND", DayOfWeek.SUNDAY, LocalTime.parse("21:45:00"), "Boeing 737-900", 350));
	  }


	public List<Flight> getFlightList(){
		return this.flights;
	}
	
	public  Flight getFlight(String flightNum) {
		for (Flight f : flights) {
			if (f.getFlightNum().equals(flightNum)) return f;
		}
		
		
		return null;
	}
}