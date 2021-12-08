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
	
	public SoapClient() {}
	
	public static void main(String[] args) throws Exception {
		SoapClient client = new SoapClient();
		
		URL url = new URL("http://localhost:8090/bookingservice?wsdl");
		QName qname = new QName("http://soap/ReservationBookingService", "ReservationBookingService");
		Service service = Service.create(url, qname);
		ReservationBookingService booking = service.getPort(ReservationBookingService.class);
		
		Scanner sc=new Scanner(System.in);  
		
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
