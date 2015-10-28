package com.jpmorgan.test;

import java.util.Date;


public class Trade {
	
	private Date date;
	private Integer quantity;
	private double price;
	private TradeAction buy_sell;
	private Stock stock;
	
	public Trade(Date date, int quantity, double price, TradeAction buy_or_sell,Stock stock) {
		this.date = date;
		this.quantity = quantity;
		this.price = price;
		this.setStock(stock);
		}
	public TradeAction getBuy_sell() {
		return buy_sell;
	}
	public void setBuy_sell(TradeAction buy_sell) {
		this.buy_sell = buy_sell;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	


}
