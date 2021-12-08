import soap.ReservationBookingService; //SOAP

import javax.xml.ws.Endpoint;


public class ServerMain {
  
  public static void main(String[] args) {
	  // publish SOAP
	  Endpoint.publish("http://localhost:8090/", new ReservationBookingService());
	  System.out.println("Started SOAP server");
  }
}