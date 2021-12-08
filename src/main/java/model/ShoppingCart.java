package model;

import java.util.*;

public class ShoppingCart{
	
	private String clientId;
	private List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
	
	public ShoppingCart(String clientId) {
		this.clientId = clientId;
	}
	
	public void addItem(String flightNum, String seatNum, String meal, int price) {
		ShoppingCartItem sci = new ShoppingCartItem(flightNum, seatNum, meal, price);
		
		if (!sci.repeat(flightNum, items)) {
			items.add(sci);
		} else {
			System.out.println("Client " + clientId + " booked a seat on this flight already");
		}
	}
	
	// calculate final price
	public int totalPrice() {
		int total = 0;
		for (ShoppingCartItem sci : items) {
			total += sci.getPrice();
		}
		return total;
	}
	
	public List<ShoppingCartItem> getCartItem(){
		return items;
	}
	
	// every booked seat gets a unique booking id
	public String getBookingId() {
		return clientId + "BK" + items.size();
	}
	
}