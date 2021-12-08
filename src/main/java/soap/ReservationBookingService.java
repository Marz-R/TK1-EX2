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
import model.AvailableFlights;

@WebService(name = "ReservationBookingService")
@SOAPBinding(style = Style.RPC)
public class ReservationBookingService {

	private Flight selectedFlight;
	//private FlightList FL = new FlightList();
	private AvailableFlights AF = new AvailableFlights(LocalDateTime.now());
	private String clientId;
	
	// implementation for client
	@WebMethod
	public void login(String clientId) {
		this.clientId = clientId;
		System.out.println("Client " + clientId + " logged in.");
	}
	
	@WebMethod
	public ArrayList<Flight> getAvailableFlightList() {
		return AF.getAvailableFlights();
	}
	
	@WebMethod
	public String[][] getSeatList(String flightNum, String seatClass){ //A: first class; B: econ plu; C: econ
		selectedFlight = AF.get(flightNum);
		
		switch(seatClass) {
		case("A"):
			return selectedFlight.getFirstClass();
		case("B"):
			return selectedFlight.getEconPlus();
		case("C"):
			return selectedFlight.getEcon();
		default:
			System.out.println("Invalid Seat Class");
			return null;
		}
	}
	
	@WebMethod
	public String booking(String seatNum, String meal) {
		return null;
	}
}