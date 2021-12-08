package model;

import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ShoppingCart{
	@XmlElement
	private String clientId;
	@XmlElement
	private List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
	@XmlElement
	private String bookingId;
	
	public ShoppingCart(String clientId) {
		this.clientId = clientId;
	}
	
	public String addItem(String flightNum, String seatNum, String meal, double price) {
		ShoppingCartItem sci = new ShoppingCartItem(flightNum, seatNum, meal, price);
		
		if (!sci.repeat(flightNum, items)) {
			items.add(sci);
			bookingId = clientId + "BK" + items.size();
		} else {
			System.out.println("Client " + clientId + " booked a seat on this flight already");
			bookingId = null;
		}
		
		return bookingId;
	}
	
	// calculate final price
	public int totalPrice() {
		int total = 0;
		for (ShoppingCartItem sci : items) {
			total += sci.getPrice();
		}
		return total;
	}
	
	public List<ShoppingCartItem> getItems(){
		return items;
	}
	
	// every booked seat gets a unique booking id
	public String getBookingId() {
		return bookingId;
	}
	
	public String getClientId() {
		return clientId;
	}
	
	public void setItems() {}
	public void setBookingId() {}
	public void setClientId() {}
	
}