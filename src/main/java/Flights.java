import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Flights{
	
	private String destination;
	private LocalDateTime departureTime; // only shows weekdays and time
	private String model;
	private char[][] FCseats;
	private char[][] EPseats;
	private char[][] Eseats;

	public Flights(String destination, LocalDateTime departureTime, String model){
		//initialize flight objects

		this.destination = destination;
		this.departureTime = departureTime;
		this.model = model;
		FCseats = setFirstClass(model);
		EPseats = setEconPlus(model);
		Eseats = setEcon(model);
	}

	public char[][] getFirstClass(){
		return this.FCseats;
	}

	public char[][] getEconPlus(){
		return this.EPseats;
	}

	public char[][] getEcon(){
		return this.Eseats;
	}

	private char[][] setFirstClass(String model){
		//return seat plan for first class
		//remember to create new char[][], to avoid null pointer
		//'P' purchased; 'R' reserved; 'E' empty; 'N' not exist
		char[][] seats;

		switch(model){
			case "Airbus319":
				break;

			case "Boeing737-900":
				break;

			case "Embraer E170":
				break;

			default:
				//wrong model message
				break;
		}

		return seats;
	}

	private char[][] setEconPlus(String model){
		//return seat plan for economy plus class
		//remember to create new char[][], to avoid null pointer
		//'P' purchased; 'R' reserved; 'E' empty; 'N' not exist
		switch(model){
			case "Airbus319":
				break;

			case "Boeing737-900":
				break;

			case "Embraer E170":
				break;

			default:
				//wrong model message
				break;
		}
	}

	private char[][] setEcon(String model){
		//return seat plan for economy class
		//remember to create new char[][], to avoid null pointer
		//'P' purchased; 'R' reserved; 'E' empty; 'N' not exist
		switch(model){
			case "Airbus319":
				break;

			case "Boeing737-900":
				break;

			case "Embraer E170":
				break;

			default:
				//wrong model message
				break;
		}
	}
}