package com.jpmorgan.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApplicationStart {

	public static void main(String[] args) {
		
		Stock tea = new Stock(StockSymbol.TEA, StockType.Common, 0,0, 100);
		Stock pop = new Stock(StockSymbol.POP, StockType.Common, 8,0, 100);
		Stock ale = new Stock(StockSymbol.ALE, StockType.Common, 23,0, 60);
		Stock gin = new Stock(StockSymbol.GIN, StockType.Preferred, 8,0.02, 100);
		Stock joe = new Stock(StockSymbol.JOE, StockType.Common, 13,0, 250);
	//	Stock tea = new Stock(StockSymbol.TEA, StockType.Common, 0,0, 100);
		
		StockHandler sthand= new StockHandler();
		
		List <Stock> stocks= new ArrayList<Stock>();
		stocks.add(tea);
		stocks.add(pop);
		stocks.add(ale);
		stocks.add(joe);
		stocks.add(gin);
		
		//Question 1
		System.out.println("Question1\n");
		//Common
		System.out.println("Dividend Yield Common:");
		System.out.println(sthand.calculateDividendYieldCommon(tea.getParValue(), tea.getLastDividend()));
		System.out.println(sthand.calculateDividendYieldCommon(pop.getParValue(), pop.getLastDividend()));
		
		//Preferred
		System.out.println("Dividend Yield Preferred\n");
		System.out.println(sthand.calculateDividendYeldPreferred(gin.getParValue(), gin.getFixedDividend(),gin.getParValue()));
		
		//Question 2
		System.out.println("Question2\n");
		System.out.println("P/E ratio");
		for (Stock s: stocks){
			if (s.getLastDividend()!=0){
				System.out.println(s.roundToDecimals(s.getParValue()/s.getLastDividend(),2));
			}
		}
		//Question 3
		System.out.println("Question3\n");
		
		Map<Trade,Stock> tradeStockPair= new HashMap<Trade,Stock>();
		
		Stock s = new Stock(StockSymbol.TEA, StockType.Common, 0,0, 100,1.12);
		Trade t1 = new Trade(getDate("2010-10-10 14:23:25"), 100, s.getTickPrice(), TradeAction.BUY,s);
		tradeStockPair.put(t1, s);
		Stock s1 = new Stock(StockSymbol.GIN, StockType.Common, 0,0, 100,1.89);
		Trade t2 = new Trade(getDate("2010-10-10 14:24:53"), 100, s.getTickPrice(), TradeAction.SELL,s);
		s.setTickPrice(1.18);
		tradeStockPair.put(t2, s1);		
		Trade t3 = new Trade(getDate("2010-10-10 14:25:33"), 100, s.getTickPrice(), TradeAction.BUY,s);
		s.setTickPrice(1.34);
		tradeStockPair.put(t3, s);
		Trade t4 = new Trade(getDate("2010-10-10 14:26:33"), 100, s.getTickPrice(), TradeAction.SELL,s);
		s.setTickPrice(1.21);
		tradeStockPair.put(t4, s);
		Trade t5 = new Trade(getDate("2010-10-10 14:27:23"), 100, s.getTickPrice(), TradeAction.SELL,s);
		tradeStockPair.put(t5, s);
		Trade t6 = new Trade(getDate("2010-10-10 14:29:13"), 100, s.getTickPrice(), TradeAction.BUY,s);
		tradeStockPair.put(t6, s);
		
		double average=0;
		int counter=0;
		Date timeNow= getDate("2010-10-10 14:40:23");
		for (Map.Entry<Trade, Stock> entry : tradeStockPair.entrySet()) {
		 
		    if(isLessThanXMinutes(timeNow.getTime(),entry.getKey().getDate().getTime(),15)){ 
		    	average+=entry.getKey().getPrice();
		    	counter+=1;
		    }
		}
		
		System.out.println("Stock price based on last 15 minute trade recorded:");
		System.out.println(getAvarage(average,counter)+"\n");
		
		//Question 5
		
		StockHandler sh = new StockHandler();
		System.out.println("Stock Price:");
		System.out.println(sh.stockPrice(tradeStockPair));
		System.out.println("\nGBCE all share index (Geometric Mean):");
		System.out.println(sh.geometricMean(tradeStockPair));		
		
	}
	
	private static double getAvarage(double average, int counter) {
		
		return average/counter;
	}

	private static boolean isLessThanXMinutes(long m1, long m2, int xminutes){
		boolean toReturn;
		long finalMinutes = TimeUnit.MILLISECONDS.toMinutes(m1-m2);
			if (finalMinutes<=xminutes)
				toReturn =true ;
			else toReturn= false;
			
		return toReturn;
	}
	
	private static Date getDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = null;
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 return d;
	}

}
