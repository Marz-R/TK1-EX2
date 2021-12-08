package model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FlightList {
	@XmlElement
	private List<Flight> flights = new ArrayList<Flight>();
	// private List<Transaction> transactions;  // list of transactions contains data: clientID, flight, seat, meal, and paid amount
	
	public FlightList() {
		setUpFlights();
	}
	
	// instantiate all flights (9 flights * 7 days)
 	private void setUpFlights() {
	    flights.add(new Flight("TK0001", "FRA", "Mon", LocalTime.parse("08:20:00"), "Embraer E170", 50));
	    flights.add(new Flight("TK0002", "AAH", "Mon", LocalTime.parse("12:40:00"), "Embraer E170", 100));
	    flights.add(new Flight("TK0003", "BER", "Mon", LocalTime.parse("22:00:00"), "Embraer E170", 200));
	    flights.add(new Flight("TK0004", "IST", "Mon", LocalTime.parse("10:15:00"), "Airbus 319", 100));
	    flights.add(new Flight("TK0005", "CDG", "Mon", LocalTime.parse("15:30:00"), "Airbus 319", 200));
	    flights.add(new Flight("TK0006", "LHR", "Mon", LocalTime.parse("19:50:00"), "Airbus 319", 300));
	    flights.add(new Flight("TK0007", "CAN", "Mon", LocalTime.parse("07:10:00"), "Boeing 737-900", 150));
	    flights.add(new Flight("TK0008", "ATL", "Mon", LocalTime.parse("13:25:00"), "Boeing 737-900", 250));
	    flights.add(new Flight("TK0009", "HND", "Mon", LocalTime.parse("21:45:00"), "Boeing 737-900", 350));

	    flights.add(new Flight("TK0010", "FRA", "Tue", LocalTime.parse("08:20:00"), "Embraer E170", 50));
	    flights.add(new Flight("TK0011", "AAH", "Tue", LocalTime.parse("12:40:00"), "Embraer E170", 100));
	    flights.add(new Flight("TK0012", "BER", "Tue", LocalTime.parse("22:00:00"), "Embraer E170", 200));
	    flights.add(new Flight("TK0013", "IST", "Tue", LocalTime.parse("10:15:00"), "Airbus 319", 100));
	    flights.add(new Flight("TK0014", "CDG", "Tue", LocalTime.parse("15:30:00"), "Airbus 319", 200));
	    flights.add(new Flight("TK0015", "LHR", "Tue", LocalTime.parse("19:50:00"), "Airbus 319", 300));
	    flights.add(new Flight("TK0016", "CAN", "Tue", LocalTime.parse("07:10:00"), "Boeing 737-900", 150));
	    flights.add(new Flight("TK0017", "ATL", "Tue", LocalTime.parse("13:25:00"), "Boeing 737-900", 250));
	    flights.add(new Flight("TK0018", "HND", "Tue", LocalTime.parse("21:45:00"), "Boeing 737-900", 350));

	    flights.add(new Flight("TK0019", "FRA", "Wed", LocalTime.parse("08:20:00"), "Embraer E170", 50));
	    flights.add(new Flight("TK0020", "AAH", "Wed", LocalTime.parse("12:40:00"), "Embraer E170", 100));
	    flights.add(new Flight("TK0021", "BER", "Wed", LocalTime.parse("22:00:00"), "Embraer E170", 200));
	    flights.add(new Flight("TK0022", "IST", "Wed", LocalTime.parse("10:15:00"), "Airbus 319", 100));
	    flights.add(new Flight("TK0023", "CDG", "Wed", LocalTime.parse("15:30:00"), "Airbus 319", 200));
	    flights.add(new Flight("TK0024", "LHR", "Wed", LocalTime.parse("19:50:00"), "Airbus 319", 300));
	    flights.add(new Flight("TK0025", "CAN", "Wed", LocalTime.parse("07:10:00"), "Boeing 737-900", 150));
	    flights.add(new Flight("TK0026", "ATL", "Wed", LocalTime.parse("13:25:00"), "Boeing 737-900", 250));
	    flights.add(new Flight("TK0027", "HND", "Wed", LocalTime.parse("21:45:00"), "Boeing 737-900", 350));

	    flights.add(new Flight("TK0028", "FRA", "Thu", LocalTime.parse("08:20:00"), "Embraer E170", 50));
	    flights.add(new Flight("TK0029", "AAH", "Thu", LocalTime.parse("12:40:00"), "Embraer E170", 100));
	    flights.add(new Flight("TK0030", "BER", "Thu", LocalTime.parse("22:00:00"), "Embraer E170", 200));
	    flights.add(new Flight("TK0031", "IST", "Thu", LocalTime.parse("10:15:00"), "Airbus 319", 100));
	    flights.add(new Flight("TK0032", "CDG", "Thu", LocalTime.parse("15:30:00"), "Airbus 319", 200));
	    flights.add(new Flight("TK0033", "LHR", "Thu", LocalTime.parse("19:50:00"), "Airbus 319", 300));
	    flights.add(new Flight("TK0034", "CAN", "Thu", LocalTime.parse("07:10:00"), "Boeing 737-900", 150));
	    flights.add(new Flight("TK0035", "ATL", "Thu", LocalTime.parse("13:25:00"), "Boeing 737-900", 250));
	    flights.add(new Flight("TK0036", "HND", "Thu", LocalTime.parse("21:45:00"), "Boeing 737-900", 350));

	    flights.add(new Flight("TK0037", "FRA", "Fri", LocalTime.parse("08:20:00"), "Embraer E170", 50));
	    flights.add(new Flight("TK0038", "AAH", "Fri", LocalTime.parse("12:40:00"), "Embraer E170", 100));
	    flights.add(new Flight("TK0039", "BER", "Fri", LocalTime.parse("22:00:00"), "Embraer E170", 200));
	    flights.add(new Flight("TK0040", "IST", "Fri", LocalTime.parse("10:15:00"), "Airbus 319", 100));
	    flights.add(new Flight("TK0041", "CDG", "Fri", LocalTime.parse("15:30:00"), "Airbus 319", 200));
	    flights.add(new Flight("TK0042", "LHR", "Fri", LocalTime.parse("19:50:00"), "Airbus 319", 300));
	    flights.add(new Flight("TK0043", "CAN", "Fri", LocalTime.parse("07:10:00"), "Boeing 737-900", 150));
	    flights.add(new Flight("TK0044", "ATL", "Fri", LocalTime.parse("13:25:00"), "Boeing 737-900", 250));
	    flights.add(new Flight("TK0045", "HND", "Fri", LocalTime.parse("21:45:00"), "Boeing 737-900", 350));

	    flights.add(new Flight("TK0046", "FRA", "Sat", LocalTime.parse("08:20:00"), "Embraer E170", 50));
	    flights.add(new Flight("TK0047", "AAH", "Sat", LocalTime.parse("12:40:00"), "Embraer E170", 100));
	    flights.add(new Flight("TK0048", "BER", "Sat", LocalTime.parse("22:00:00"), "Embraer E170", 200));
	    flights.add(new Flight("TK0049", "IST", "Sat", LocalTime.parse("10:15:00"), "Airbus 319", 100));
	    flights.add(new Flight("TK0050", "CDG", "Sat", LocalTime.parse("15:30:00"), "Airbus 319", 200));
	    flights.add(new Flight("TK0051", "LHR", "Sat", LocalTime.parse("19:50:00"), "Airbus 319", 300));
	    flights.add(new Flight("TK0052", "CAN", "Sat", LocalTime.parse("07:10:00"), "Boeing 737-900", 150));
	    flights.add(new Flight("TK0053", "ATL", "Sat", LocalTime.parse("13:25:00"), "Boeing 737-900", 250));
			flights.add(new Flight("TK0054", "HND", "Sat", LocalTime.parse("21:45:00"), "Boeing 737-900", 350));

	    flights.add(new Flight("TK0055", "FRA", "Sun", LocalTime.parse("08:20:00"), "Embraer E170", 50));
	    flights.add(new Flight("TK0056", "AAH", "Sun", LocalTime.parse("12:40:00"), "Embraer E170", 100));
	    flights.add(new Flight("TK0057", "BER", "Sun", LocalTime.parse("22:00:00"), "Embraer E170", 200));
	    flights.add(new Flight("TK0058", "IST", "Sun", LocalTime.parse("10:15:00"), "Airbus 319", 100));
	    flights.add(new Flight("TK0059", "CDG", "Sun", LocalTime.parse("15:30:00"), "Airbus 319", 200));
	    flights.add(new Flight("TK0060", "LHR", "Sun", LocalTime.parse("19:50:00"), "Airbus 319", 300));
	    flights.add(new Flight("TK0061", "CAN", "Sun", LocalTime.parse("07:10:00"), "Boeing 737-900", 150));
	    flights.add(new Flight("TK0062", "ATL", "Sun", LocalTime.parse("13:25:00"), "Boeing 737-900", 250));
	    flights.add(new Flight("TK0063", "HND", "Sun", LocalTime.parse("21:45:00"), "Boeing 737-900", 350));
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