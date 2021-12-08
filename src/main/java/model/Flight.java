package model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.xml.bind.annotation.XmlElement;


// TODO: add function to update seats <- indexing: update(char/String row, int col) {translate char/String to int} ? ex. seat A15
public class Flight {
 
	public Flight() {
		
	}
	
	public Flight(String flightNum, String destination, DayOfWeek dayOfWeek, LocalTime departureTime, String model, int price) {
	    //initialize flight objects
	    this.flightNum = flightNum;
	    this.destination = destination;
	    this.dayOfWeek = dayOfWeek;
	    this.departureTime = departureTime;
	    this.model = model;
	    this.price = price;
	    FCseats = setFirstClass(model);
	    EPseats = setEconPlus(model);
	    Eseats = setEcon(model);
	  }


	@XmlElement
	private String flightNum;  // flight identifier
	@XmlElement
	private String destination;
	@XmlElement
	private DayOfWeek dayOfWeek;  // Mon, Tue, Wed, Thu, Fri, Sat, Sun
	@XmlElement
	private LocalTime departureTime;  // HH:mm:ss
	@XmlElement
	private String model;
	@XmlElement
	private double price; // basic price for the flight
  
	@XmlElement
	private String[][] FCseats;
	@XmlElement
	private String[][] EPseats;
	@XmlElement
	private String[][] Eseats;
	@XmlElement
	private int remainingFCseatsNum;
	@XmlElement
	private int remainingEPseatsNum;
	@XmlElement
  	private int remainingEseatsNum;
	

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

	public double getPrice() {
		return this.price;
	}

	public String[][] getFirstClass() {
		return this.FCseats;
	}

	public String[][] getEconPlus() {
		return this.EPseats;
	}

	public String[][] getEcon() {
		return this.Eseats;
	}

	public int getRemainingFCseatsNum() {
		// count frequency of each value
		Map<String, Long> counts = 
				Arrays.stream(FCseats)
				.flatMap(Arrays::stream)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Long numRemainingSeats = counts.get("E");
		return numRemainingSeats == null ? 0 : numRemainingSeats.intValue();  // null means there was no key "E", which means there was no empty seats remaining
	}

	public int getRemainingEPseatsNum() {
		// count frequency of each value
		Map<String, Long> counts = 
				Arrays.stream(EPseats)
				.flatMap(Arrays::stream)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Long numRemainingSeats = counts.get("E");
		return numRemainingSeats == null ? 0 : numRemainingSeats.intValue();  // null means there was no key "E", which means there was no empty seats remaining
	}

	public int getRemainingEseatsNum() {
		// count frequency of each value
		Map<String, Long> counts = 
				Arrays.stream(Eseats)
				.flatMap(Arrays::stream)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Long numRemainingSeats = counts.get("E");
		return numRemainingSeats == null ? 0 : numRemainingSeats.intValue();  // null means there was no key "E", which means there was no empty seats remaining
	}

	private String[][] setFirstClass(String model) {
		//return seat plan for first class
		//remember to create new char[][], to avoid null pointer
		//'P' purchased; 'R' reserved; 'E' empty; 'N' not exist
		String[][] seats;
		
		price *= 2; 

		switch(model){
		case "Airbus 319":
			seats = new String[2][4]; // char[row][col]
        	for (int i = 0; i < 2; i++){
        		for (int j = 0; j < 4; j++){
        			seats[i][j] = "E";
        		}
        	}
        	break;

		case "Boeing 737-900":
			seats = new String[5][4];
			for (int i = 0; i < 5; i++){
				for (int j = 0; j < 4; j++){
					seats[i][j] = "E";
				}
			}
			break;

		case "Embraer E170":
			seats = new String[2][3];
			for (int i = 0; i < 2; i++){
				for (int j = 0; j < 3; j++){
					seats[i][j] = "E";
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
	
	private String[][] setEconPlus(String model) {
		//return seat plan for economy plus class
		//remember to create new char[][], to avoid null pointer
		//'P' purchased; 'R' reserved; 'E' empty; 'N' not exist
		String[][] seats;
		
		price *= 1.5;

		switch(model){
		case "Airbus 319":
			seats = new String[7][6];
			for (int i = 0; i < 7; i++){
				for (int j = 0; j < 6; j++){
					seats[i][j] = "E";
				}
			}
			break;

		case "Boeing 737-900":
			seats = new String[8][6]; // special structure, refer to pdf
			for (int i = 0; i < 8; i++){
				for (int j = 0; j < 6; j++){
					if (i == 0 && j < 3 || i == 5 && j > 2){
						seats[i][j] = "N";
					} else{
						seats[i][j] = "E";
					}
				}
			}
			break;

		case "Embraer E170":
			seats = new String[4][4];
			for (int i = 0; i < 4; i++){
				for (int j = 0; j < 4; j++){
					seats[i][j] = "E";
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

	private String[][] setEcon(String model) {
		//return seat plan for economy class
		//remember to create new char[][], to avoid null pointer
		//'P' purchased; 'R' reserved; 'E' empty; 'N' not exist
		String[][] seats;
		
		switch(model){
		case "Airbus 319":
			seats = new String[13][6];
			for (int i = 0; i < 13; i++){
				for (int j = 0; j < 6; j++){
					seats[i][j] = "E";
				}
			}
			break;

		case "Boeing 737-900":
			seats = new String[20][6];
			for (int i = 0; i < 20; i++){
				for (int j = 0; j < 6; j++){
					seats[i][j] = "E";
				}
			}
			break;

		case "Embraer E170":
			seats = new String[12][4];
			for (int i = 0; i < 12; i++){
				for (int j = 0; j < 4; j++){
					seats[i][j] = "E";
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