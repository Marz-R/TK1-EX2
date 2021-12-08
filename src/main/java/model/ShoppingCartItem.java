package model;

import java.util.List;

public class ShoppingCartItem{
	
	private String flightNum;
	private String seatNum;
	private String meal;
	private double price;
	
	public ShoppingCartItem(String flightNum, String seatNum, String meal, double price){
		this.flightNum = flightNum;
		this.seatNum = seatNum;
		this.meal = meal;
		this.price = price;
	}
	
	public String getFlightNum() {
		return this.flightNum;
	}
	
	public String getSeatNum() {
		return this.seatNum;
	}
	
	public String getMeal() {
		return this.meal;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	// check if client book the same flight twice
	public boolean repeat(String flightNum, List<ShoppingCartItem> items) {
		for (ShoppingCartItem sci : items) {
			if (sci.getFlightNum().equals(flightNum)) return true;
		}
		return false;
	}
}
