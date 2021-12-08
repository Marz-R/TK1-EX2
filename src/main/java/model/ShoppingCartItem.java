package model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ShoppingCartItem{
	@XmlElement
	private String flightNum;
	@XmlElement
	private String seatNum;
	@XmlElement
	private String meal;
	@XmlElement
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
	
	public void setFlightNum() {}
	public void setSeatNum() {}
	public void setMeal() {}
	public void setPrice() {}
	
	// check if client book the same flight twice
	public boolean repeat(String flightNum, List<ShoppingCartItem> items) {
		for (ShoppingCartItem sci : items) {
			if (sci.getFlightNum().equals(flightNum)) return true;
		}
		return false;
	}
}
