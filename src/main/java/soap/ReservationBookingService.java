package soap;

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
import model.ShoppingCartItem;

@WebService(name = "ReservationBookingService")
@SOAPBinding(style = Style.RPC)
public class ReservationBookingService {

	private Flight selectedFlight;
	//private FlightList FL = new FlightList();
	private AvailableFlights AF = new AvailableFlights(LocalDateTime.now());
	private ShoppingCart cart;
	private String[][] tempSeat;
	
	// implementation for client
	@WebMethod
	public void login(String clientId) {
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
		//translate seat number to integers row and col for String[][]
		int row;
		int col;
		char[] c = new char[2]; // char[0]: row, char[1]: column
		
		if (seatNum.length() == 2) {
			c = seatNum.toCharArray();
		} else {
			System.out.println("Invalid Seat Number");
			return null;
		}
		
		if (Character.getNumericValue(c[0]) <= tempSeat.length) {
			row = Character.getNumericValue(c[0]) - 1; // if input = 2A, row = 1
		}else {
			System.out.println("Invalid Seat Number");
			return null;
		}
		
		switch(c[1]) {
			case 'A':
				col = 0;
			case 'B':
				col = 1;
			case 'C':
				col = 2;
			case 'D':
				col = 3;
			case 'E':
				col = 4;
			case 'F':
				col = 5;
			default:
				col = 100;
		}
		
		//check if seat is empty
		if (tempSeat[row][col] == "E") {
			//change empty seat to reserved seat
			tempSeat[row][col] = "R";
			return cart.addItem(selectedFlight.getFlightNum(), seatNum, meal, selectedFlight.getPrice());
		} else if(col == 100) {
			System.out.println("Invalid Seat Number");
			return null;
		} else {
			System.out.println("This seat is occupied");
			return null;
		}

	}
	
	@WebMethod
	public double payment() {
		double total = 0;
		List<ShoppingCartItem> items = cart.getCartItem();
		
		System.out.println("Shopping Cart");
		System.out.println("FlightID  SeatID  Meal  Price");
		for (ShoppingCartItem i: items) {
			System.out.println(i.getFlightNum() + "  " + i.getSeatNum() + "  " + i.getMeal() + "  " + i.getPrice());
			total += i.getPrice();
		}
		
		return total;
	}
}