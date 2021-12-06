import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Flight {
	private String flightNum;  // flight identifier
	private String destination;
	// private LocalDateTime departureTime;
	private DayOfWeek dayOfWeek;  // Mon, Tue, Wed, Thu, Fri, Sat, Sun
	private LocalTime departureTime;  // HH:mm:ss
	private String model;
	private char[][] FCseats;
	private char[][] EPseats;
	private char[][] Eseats;

	public Flight(String flightNum, String destination, DayOfWeek dayOfWeek, LocalTime departureTime, String model) {
		//initialize flight objects

		this.flightNum = flightNum;
		this.destination = destination;
		this.dayOfWeek = dayOfWeek;
		this.departureTime = departureTime;
		this.model = model;
		FCseats = setFirstClass(model);
		EPseats = setEconPlus(model);
		Eseats = setEcon(model);
	}

	public String getFlightNum() {
		return this.flightNum;
	}

	public String getDestination() {
		return this.destination;
	}

	public DayOfWeek getDayOfWeek() {
		return this.dayOfWeek;
	}

	public LocalTime getDepartureTime() {
		return this.departureTime;
	}

	public String getModel() {
		return this.model;
	}

	public char[][] getFirstClass() {
		return this.FCseats;
	}

	public char[][] getEconPlus() {
		return this.EPseats;
	}

	public char[][] getEcon() {
		return this.Eseats;
	}

	private char[][] setFirstClass(String model) {
		//return seat plan for first class
		//remember to create new char[][], to avoid null pointer
		//'P' purchased; 'R' reserved; 'E' empty; 'N' not exist
		char[][] seats;

		switch(model){
			case "Airbus 319":
				seats = new char[2][4]; // char[row][col]
				for (int i = 0; i < 2; i++){
					for (int j = 0; j < 4; j++){
						seats[i][j] = 'E';
					}
				}
				break;

			case "Boeing 737-900":
				seats = new char[5][4];
				for (int i = 0; i < 5; i++){
					for (int j = 0; j < 4; j++){
						seats[i][j] = 'E';
					}
				}
				break;

			case "Embraer E170":
				seats = new char[2][3];
				for (int i = 0; i < 2; i++){
					for (int j = 0; j < 3; j++){
						seats[i][j] = 'E';
					}
				}
				break;

			default:
				//wrong model message
				seats = null;
				System.out.println("Invalid model");
				break;
		}

		return seats;
	}

	private char[][] setEconPlus(String model) {
		//return seat plan for economy plus class
		//remember to create new char[][], to avoid null pointer
		//'P' purchased; 'R' reserved; 'E' empty; 'N' not exist
		char[][] seats;

		switch(model){
			case "Airbus 319":
				seats = new char[7][6];
				for (int i = 0; i < 7; i++){
					for (int j = 0; j < 6; j++){
						seats[i][j] = 'E';
					}
				}
				break;

			case "Boeing 737-900":
				seats = new char[8][6]; // special structure, refer to pdf
				for (int i = 0; i < 8; i++){
					for (int j = 0; j < 6; j++){
						if (i == 0 && j < 3 || i == 5 && j > 2){
							seats[i][j] = 'N';
						} else{
							seats[i][j] = 'E';
						}
					}
				}
				break;

			case "Embraer E170":
				seats = new char[4][4];
				for (int i = 0; i < 4; i++){
					for (int j = 0; j < 4; j++){
						seats[i][j] = 'E';
					}
				}
				break;

			default:
				//wrong model message
				seats = null;
				System.out.println("Invalid model");
				break;
		}

		return seats;
	}

	private char[][] setEcon(String model) {
		//return seat plan for economy class
		//remember to create new char[][], to avoid null pointer
		//'P' purchased; 'R' reserved; 'E' empty; 'N' not exist
		char[][] seats;

		switch(model){
			case "Airbus 319":
				seats = new char[13][6];
				for (int i = 0; i < 13; i++){
					for (int j = 0; j < 6; j++){
						seats[i][j] = 'E';
					}
				}
				break;

			case "Boeing 737-900":
				seats = new char[20][6];
				for (int i = 0; i < 20; i++){
					for (int j = 0; j < 6; j++){
						seats[i][j] = 'E';
					}
				}
				break;

			case "Embraer E170":
				seats = new char[12][4];
				for (int i = 0; i < 12; i++){
					for (int j = 0; j < 4; j++){
						seats[i][j] = 'E';
					}
				}
				break;

			default:
				//wrong model message
				seats = null;
				System.out.println("Invalid model");
				break;
		}

		return seats;
	}
}