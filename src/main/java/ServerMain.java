import soap.ReservationBookingService; //SOAP
import javax.xml.ws.Endpoint;

import java.io.IOException;

public class ServerMain {
  
  public static void main(String[] args) throws IOException {
  
	  (new Thread() {
		  @Override
	      public void run() {
	    	  // publish REST
	      }
	  }).run();

	  (new Thread() {
		  @Override
		  public void run() {
			  // publish SOAP
        Endpoint.publish("http://localhost:8090/bookingservice", new ReservationBookingService());
        System.out.println("Started SOAP server");
	      }
	   }).run();
  }
}