package model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.xml.bind.annotation.XmlElement;


// TODO: add function to update seats <- indexing: update(char/String row, int col) {translate char/String to int} ? ex. seat A15
public class Flight {

  private static Flight[] flightList = {
    // instantiate all flights (9 flights * 7 days)
    // these are the actual objects that are going to be modified (i.e. value of seat arrays will be changed)
    new Flight("TK0001", "FRA", DayOfWeek.MONDAY, LocalTime.parse("08:20:00"), "Embraer E170", 50),
    new Flight("TK0002", "AAH", DayOfWeek.MONDAY, LocalTime.parse("12:40:00"), "Embraer E170", 100),
    new Flight("TK0003", "BER", DayOfWeek.MONDAY, LocalTime.parse("22:00:00"), "Embraer E170", 200),
    new Flight("TK0004", "IST", DayOfWeek.MONDAY, LocalTime.parse("10:15:00"), "Airbus 319", 100),
    new Flight("TK0005", "CDG", DayOfWeek.MONDAY, LocalTime.parse("15:30:00"), "Airbus 319", 200),
    new Flight("TK0006", "LHR", DayOfWeek.MONDAY, LocalTime.parse("19:50:00"), "Airbus 319", 300),
    new Flight("TK0007", "CAN", DayOfWeek.MONDAY, LocalTime.parse("07:10:00"), "Boeing 737-900", 150),
    new Flight("TK0008", "ATL", DayOfWeek.MONDAY, LocalTime.parse("13:25:00"), "Boeing 737-900", 250),
    new Flight("TK0009", "HND", DayOfWeek.MONDAY, LocalTime.parse("21:45:00"), "Boeing 737-900", 350),

    new Flight("TK0010", "FRA", DayOfWeek.TUESDAY, LocalTime.parse("08:20:00"), "Embraer E170", 50),
    new Flight("TK0011", "AAH", DayOfWeek.TUESDAY, LocalTime.parse("12:40:00"), "Embraer E170", 100),
    new Flight("TK0012", "BER", DayOfWeek.TUESDAY, LocalTime.parse("22:00:00"), "Embraer E170", 200),
    new Flight("TK0013", "IST", DayOfWeek.TUESDAY, LocalTime.parse("10:15:00"), "Airbus 319", 100),
    new Flight("TK0014", "CDG", DayOfWeek.TUESDAY, LocalTime.parse("15:30:00"), "Airbus 319", 200),
    new Flight("TK0015", "LHR", DayOfWeek.TUESDAY, LocalTime.parse("19:50:00"), "Airbus 319", 300),
    new Flight("TK0016", "CAN", DayOfWeek.TUESDAY, LocalTime.parse("07:10:00"), "Boeing 737-900", 150),
    new Flight("TK0017", "ATL", DayOfWeek.TUESDAY, LocalTime.parse("13:25:00"), "Boeing 737-900", 250),
    new Flight("TK0018", "HND", DayOfWeek.TUESDAY, LocalTime.parse("21:45:00"), "Boeing 737-900", 350),

    new Flight("TK0019", "FRA", DayOfWeek.WEDNESDAY, LocalTime.parse("08:20:00"), "Embraer E170", 50),
    new Flight("TK0020", "AAH", DayOfWeek.WEDNESDAY, LocalTime.parse("12:40:00"), "Embraer E170", 100),
    new Flight("TK0021", "BER", DayOfWeek.WEDNESDAY, LocalTime.parse("22:00:00"), "Embraer E170", 200),
    new Flight("TK0022", "IST", DayOfWeek.WEDNESDAY, LocalTime.parse("10:15:00"), "Airbus 319", 100),
    new Flight("TK0023", "CDG", DayOfWeek.WEDNESDAY, LocalTime.parse("15:30:00"), "Airbus 319", 200),
    new Flight("TK0024", "LHR", DayOfWeek.WEDNESDAY, LocalTime.parse("19:50:00"), "Airbus 319", 300),
    new Flight("TK0025", "CAN", DayOfWeek.WEDNESDAY, LocalTime.parse("07:10:00"), "Boeing 737-900", 150),
    new Flight("TK0026", "ATL", DayOfWeek.WEDNESDAY, LocalTime.parse("13:25:00"), "Boeing 737-900", 250),
    new Flight("TK0027", "HND", DayOfWeek.WEDNESDAY, LocalTime.parse("21:45:00"), "Boeing 737-900", 350),

    new Flight("TK0028", "FRA", DayOfWeek.THURSDAY, LocalTime.parse("08:20:00"), "Embraer E170", 50),
    new Flight("TK0029", "AAH", DayOfWeek.THURSDAY, LocalTime.parse("12:40:00"), "Embraer E170", 100),
    new Flight("TK0030", "BER", DayOfWeek.THURSDAY, LocalTime.parse("22:00:00"), "Embraer E170", 200),
    new Flight("TK0031", "IST", DayOfWeek.THURSDAY, LocalTime.parse("10:15:00"), "Airbus 319", 100),
    new Flight("TK0032", "CDG", DayOfWeek.THURSDAY, LocalTime.parse("15:30:00"), "Airbus 319", 200),
    new Flight("TK0033", "LHR", DayOfWeek.THURSDAY, LocalTime.parse("19:50:00"), "Airbus 319", 300),
    new Flight("TK0034", "CAN", DayOfWeek.THURSDAY, LocalTime.parse("07:10:00"), "Boeing 737-900", 150),
    new Flight("TK0035", "ATL", DayOfWeek.THURSDAY, LocalTime.parse("13:25:00"), "Boeing 737-900", 250),
    new Flight("TK0036", "HND", DayOfWeek.THURSDAY, LocalTime.parse("21:45:00"), "Boeing 737-900", 350),

    new Flight("TK0037", "FRA", DayOfWeek.FRIDAY, LocalTime.parse("08:20:00"), "Embraer E170", 50),
    new Flight("TK0038", "AAH", DayOfWeek.FRIDAY, LocalTime.parse("12:40:00"), "Embraer E170", 100),
    new Flight("TK0039", "BER", DayOfWeek.FRIDAY, LocalTime.parse("22:00:00"), "Embraer E170", 200),
    new Flight("TK0040", "IST", DayOfWeek.FRIDAY, LocalTime.parse("10:15:00"), "Airbus 319", 100),
    new Flight("TK0041", "CDG", DayOfWeek.FRIDAY, LocalTime.parse("15:30:00"), "Airbus 319", 200),
    new Flight("TK0042", "LHR", DayOfWeek.FRIDAY, LocalTime.parse("19:50:00"), "Airbus 319", 300),
    new Flight("TK0043", "CAN", DayOfWeek.FRIDAY, LocalTime.parse("07:10:00"), "Boeing 737-900", 150),
    new Flight("TK0044", "ATL", DayOfWeek.FRIDAY, LocalTime.parse("13:25:00"), "Boeing 737-900", 250),
    new Flight("TK0045", "HND", DayOfWeek.FRIDAY, LocalTime.parse("21:45:00"), "Boeing 737-900", 350),

    new Flight("TK0046", "FRA", DayOfWeek.SATURDAY, LocalTime.parse("08:20:00"), "Embraer E170", 50),
    new Flight("TK0047", "AAH", DayOfWeek.SATURDAY, LocalTime.parse("12:40:00"), "Embraer E170", 100),
    new Flight("TK0048", "BER", DayOfWeek.SATURDAY, LocalTime.parse("22:00:00"), "Embraer E170", 200),
    new Flight("TK0049", "IST", DayOfWeek.SATURDAY, LocalTime.parse("10:15:00"), "Airbus 319", 100),
    new Flight("TK0050", "CDG", DayOfWeek.SATURDAY, LocalTime.parse("15:30:00"), "Airbus 319", 200),
    new Flight("TK0051", "LHR", DayOfWeek.SATURDAY, LocalTime.parse("19:50:00"), "Airbus 319", 300),
    new Flight("TK0052", "CAN", DayOfWeek.SATURDAY, LocalTime.parse("07:10:00"), "Boeing 737-900", 150),
    new Flight("TK0053", "ATL", DayOfWeek.SATURDAY, LocalTime.parse("13:25:00"), "Boeing 737-900", 250),
    new Flight("TK0054", "HND", DayOfWeek.SATURDAY, LocalTime.parse("21:45:00"), "Boeing 737-900", 350),

    new Flight("TK0055", "FRA", DayOfWeek.SUNDAY, LocalTime.parse("08:20:00"), "Embraer E170", 50),
    new Flight("TK0056", "AAH", DayOfWeek.SUNDAY, LocalTime.parse("12:40:00"), "Embraer E170", 100),
    new Flight("TK0057", "BER", DayOfWeek.SUNDAY, LocalTime.parse("22:00:00"), "Embraer E170", 200),
    new Flight("TK0058", "IST", DayOfWeek.SUNDAY, LocalTime.parse("10:15:00"), "Airbus 319", 100),
    new Flight("TK0059", "CDG", DayOfWeek.SUNDAY, LocalTime.parse("15:30:00"), "Airbus 319", 200),
    new Flight("TK0060", "LHR", DayOfWeek.SUNDAY, LocalTime.parse("19:50:00"), "Airbus 319", 300),
    new Flight("TK0061", "CAN", DayOfWeek.SUNDAY, LocalTime.parse("07:10:00"), "Boeing 737-900", 150),
    new Flight("TK0062", "ATL", DayOfWeek.SUNDAY, LocalTime.parse("13:25:00"), "Boeing 737-900", 250),
    new Flight("TK0063", "HND", DayOfWeek.SUNDAY, LocalTime.parse("21:45:00"), "Boeing 737-900", 350)
  };

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

  public static Flight[] getFlightList() {
    return flightList;
  }

  public static Flight getFlight(String flightNum) {
    for (Flight f : flightList) {
      if (f.getFlightNum().equals(flightNum)) return f;
    }

    return null;
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