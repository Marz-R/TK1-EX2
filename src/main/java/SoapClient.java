import soap.ReservationBookingService;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SoapClient {
	
	private String clientId;
	
	public SoapClient(String clientId) {
		this.clientId = clientId;
	}
	
	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://localhost:8090/bookingservice");
		
	}
}
