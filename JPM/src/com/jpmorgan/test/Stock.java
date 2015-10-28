package com.jpmorgan.test;


public class Stock {
	
	private StockSymbol symbol;
	private StockType type;
	private double lastDividend;
	private double fixedDividend;
	private double parValue;
	private double tickPrice;
	
	
	public Stock(StockSymbol symbol, StockType type, double lastDividend, double fixedDividend, double parValue) {
		this.symbol = symbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}
	public Stock(StockSymbol symbol, StockType type, double lastDividend, double fixedDividend, double parValue, double tickPrice) {
		this.symbol = symbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
		this.setTickPrice(tickPrice);
	}
	
	public StockSymbol getSymbol() {
		return symbol;
	}
	public void setSymbol(StockSymbol symbol) {
		this.symbol = symbol;
	}
	public StockType getType() {
		return type;
	}
	public void setType(StockType type) {
		this.type = type;
	}
	public double getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}
	public double getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	public double getParValue() {
		return parValue;
	}
	public void setParValue(double parValue) {
		this.parValue = parValue;
	}
	
	public double roundToDecimals(double d, int number)  
	{   
	   int tmp = (int)(d * Math.pow(10 , number));  
	   return ((double)tmp)/Math.pow(10 , number);  
	}
	public double getTickPrice() {
		return tickPrice;
	}
	public void setTickPrice(double tickPrice) {
		this.tickPrice = tickPrice;
	}
	
}


