import soap.ReservationBookingService;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;
import java.util.*;

import soap.ReservationBookingService;

public class SoapClient {
	//@WebServiceRef(wsdlLocation = "http://localhost:8090/bookingservice/ReservationBookingService?WSDL")
	//private static ReservationBookingService service;
	private String clientId = UUID.randomUUID().toString();;
	
	public SoapClient() {
		
	}
	
	public static void main(String[] args) throws Exception {
		SoapClient client = new SoapClient();
		
		URL url = new URL("http://localhost:8090/bookingservice?wsdl");
		
		//1st argument service URI, which i actually have no idea what it should be
		//2nd argument is service name
		QName qname = new QName("http://localhost:8090/bookingservice?wsdl", "ReservationBookingService");

		Service service = Service.create(url, qname);

		ReservationBookingService booking = service.getPort(ReservationBookingService.class);
		
		booking.login(client.clientId);
		
		// get and print available flights
		booking.getAvailableFlightList();

		//TODO input flight number and class
		booking.getSeatList(null, null);
		
		//TODO transform seat list to plan
		
		//TODO input seat number and meal
		booking.booking(null, null); // return booking id
		
	}
}
