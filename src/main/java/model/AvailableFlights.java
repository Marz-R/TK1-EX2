package model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AvailableFlights {
  @XmlElement
  private ArrayList<Flight> availableFlights = new ArrayList<Flight>();
  private FlightList flightsList = new FlightList();

  public AvailableFlights(LocalDateTime currentDayTime) {
    int currentDayOfWeekInt = currentDayTime.getDayOfWeek().getValue();  // 1: Mon, 2: Tue, ... 7: Sun
    DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalTime currentTime = LocalTime.parse(currentDayTime.format(f));

    for (Flight flight : flightsList.getFlightList()) {
      /* 
      * The day of week the flight departure must be later than current day of week.
      * The departure time of the flight must be later than current time.
      * The flight must have at least 3 available first class seats, 5 available economy plus seats,
      * and 10 available economy seats to be considered as "available for the customer".
      */ 
      if (flight.getDayOfWeekInt() >= currentDayOfWeekInt  // DayOfWeek is enum object so the later day of week has larger int value
        && flight.getDepartureTime().isAfter(currentTime)  // is this flight's departure time later than current time?
        && flight.getRemainingFCseatsNum() >= 3
        && flight.getRemainingEPseatsNum() >= 5
        && flight.getRemainingEseatsNum() >= 10) {

        availableFlights.add(flight);
      }
    }
  }

  public ArrayList<Flight> getAvailableFlights() {
    return availableFlights;
  }

  public Flight get(String flightNum) {
    for (Flight f : availableFlights) {
      if (f.getFlightNum().equals(flightNum)) return f;
    }

    System.out.println("Invalid Flight Number");
    return null;
  }
}
