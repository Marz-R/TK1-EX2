package soap;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.Flight;
import model.FlightList;

@WebService(name = "ReservationBookingService")
@SOAPBinding(style = Style.RPC)
public class ReservationBookingService {

	FlightList flights = new FlightList();
	
	// implementation for web service
	
	
	
	// implementation for client
	@WebMethod
	public void login(String ClientId) {
		
	}
	
	@WebMethod
	public List<Flight> getFlightList() {
		return flights.getFlightList();
	}
}