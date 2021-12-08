import soap.ReservationBookingService;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;

import model.Flight;

import java.util.*;

import soap.ReservationBookingService;

public class SoapClient {
	//@WebServiceRef(wsdlLocation = "http://localhost:8090/bookingservice/ReservationBookingService?WSDL")
	//private static ReservationBookingService service;
	private String clientId = UUID.randomUUID().toString();;
	
	public SoapClient() {}
	
	private static void printSeats(String[][] seats) {
		char c = 'A';
		
		System.out.print("  ");
		for(int j = 0; j < seats[0].length; j++) {
			System.out.print(c + " ");
			c++;
		}
		
		for(int i = 0; i < seats.length; i++) {
			System.out.print((i+1) + " ");
			
			for(String s : seats[i]) {
				if (s.equals("E")) {
					System.out.print("O ");
				} else {
					System.out.print("X ");
				}
			}
		}
	}
	
	private static void bookingService(ReservationBookingService booking) {
		Scanner sc = new Scanner(System.in);
		
		// get and print available flights
		System.out.println("Available flights: ");
		System.out.println("FlightID  Destination  Date  Time  Model  BasicPrice");
		ArrayList<Flight> fl = booking.getAvailableFlightList();
		for (Flight f: fl) {
			System.out.println(f.getFlightNum() + "  " + f.getDestination() + "  " + f.getDayOfWeek().toString() + "  " + f.getDepartureTime().toString() + "  " + f.getModel() + "  " + f.getPrice());
		}

		// input flight number and class
		System.out.println("Please input the flight ID that you want to book: ");
		String fid = sc.nextLine();
		
		System.out.println("Please input the LETTER representing seat class that you want to book: ");
		System.out.println("A: First Class");
		System.out.println("B: Economy Plus Class");
		System.out.println("C: Economy Class");
		String sclass = sc.nextLine();
		
		String[][] seats = booking.getSeatList(fid, sclass);
		printSeats(seats);
		
		// input seat number and meal
		System.out.println("Please input the seat ID that you want to book: ");
		String sid = sc.nextLine();
		
		System.out.println("Please input the meal plan that you want to book: ");
		System.out.println("normal/vegan/vegetarian");
		
		String meal = sc.nextLine();
		String bid = booking.booking(sid, meal); // return booking id
		System.out.println("Here's the booking ID for this reservation: " + bid);
		
	}
	
	
	public static void main(String[] args) throws Exception {
		SoapClient client = new SoapClient();
		
		URL url = new URL("http://localhost:8090/bookingservice?wsdl");
		QName qname = new QName("http://soap/ReservationBookingService", "ReservationBookingService");
		Service service = Service.create(url, qname);
		ReservationBookingService booking = service.getPort(ReservationBookingService.class);
		
		Scanner sc = new Scanner(System.in);
		Boolean b = true;
		
		booking.login(client.clientId);
		
		while(b) {
			bookingService(booking);
			System.out.println("You want to book another flight? (True/False)");
			b = sc.nextBoolean();
		}
		
		double amount = booking.payment();
		System.out.println("Total amount is: " + amount);
		System.out.println("Thank you and goodbye!");
		
	}
}
