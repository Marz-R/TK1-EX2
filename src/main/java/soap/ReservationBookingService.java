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
import model.ShoppingCart;

@WebService(name = "ReservationBookingService")
@SOAPBinding(style = Style.RPC)
public class ReservationBookingService {

	private Flight selectedFlight;
	//private FlightList FL = new FlightList();
	private AvailableFlights AF = new AvailableFlights(LocalDateTime.now());
	private String clientId;
	private ShoppingCart cart;
	private String[][] tempSeat;
	
	// implementation for client
	@WebMethod
	public void login(String clientId) {
		this.clientId = clientId;
		cart = new ShoppingCart(clientId);
		System.out.println("Client " + clientId + " logged in.");
	}
	
	@WebMethod
	public ArrayList<Flight> getAvailableFlightList() {
		return AF.getAvailableFlights();
	}
	
	@WebMethod
	public String[][] getSeatList(String flightNum, String seatClass){ //A: first class; B: econ plu; C: econ
		selectedFlight = AF.get(flightNum); // return the Flight obj of the chosen flight
		
		switch(seatClass) {
		case("A"):
			tempSeat = selectedFlight.getFirstClass();
		case("B"):
			tempSeat = selectedFlight.getEconPlus();
		case("C"):
			tempSeat = selectedFlight.getEcon();
		default:
			System.out.println("Invalid Seat Class");
			tempSeat = null;
		}
		
		return tempSeat;
	}
	
	@WebMethod
	public String booking(String seatNum, String meal) {
		//TODO translate seat number to integers i and j for String[][]
		//TODO check if seat is empty
		//TODO change empty seat to reserved seat
		return cart.addItem(selectedFlight.getFlightNum(), seatNum, meal, selectedFlight.getPrice());
		//return null;
	}
}