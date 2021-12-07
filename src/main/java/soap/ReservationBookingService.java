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

	private FlightList flights = new FlightList();
	private String clientId;
	
	// implementation for client
	@WebMethod
	public void login(String clientId) {
		this.clientId = clientId;
		System.out.println("Client " + clientId + " logged in.");
	}
	
	@WebMethod
	public List<Flight> getFlightList(LocalDateTime currentDayTime) {
		return flights.getFlightList();
	}
}