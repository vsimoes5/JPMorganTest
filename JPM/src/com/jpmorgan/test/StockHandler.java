package com.jpmorgan.test;

import java.util.Map;

public class StockHandler {
	
    public double calculateDividendYieldCommon(double tickPrice, double lastDividend) {
        
      	return lastDividend / tickPrice;
    }

    public double calculateDividendYeldPreferred(double tickPrice, double fixedDividend, double parValue){
    	
    	return (fixedDividend * parValue) / tickPrice;
    }
    
    public double stockPrice( Map<Trade, Stock> tradeStockPair ){
		double sumOfPriceTimesQuantity;
		double sumOfQuantities;
		
		sumOfPriceTimesQuantity= sumOfPriceTimesQuantity(tradeStockPair);
		sumOfQuantities=SumOfQuantities(tradeStockPair);
    	
    	return sumOfPriceTimesQuantity/sumOfQuantities;
    	
    }
    
    private static int SumOfQuantities(Map<Trade, Stock> tradeStockPair) {
    	int quantity=0;
    	
    	for (Map.Entry<Trade, Stock> entry : tradeStockPair.entrySet()){
    		quantity+=entry.getKey().getQuantity();
    	}		
    	
		return quantity;
	}

	private static double sumOfPriceTimesQuantity(Map<Trade, Stock> tradeStockPair){
		double priceTimesQuantity=0d;
		for (Map.Entry<Trade, Stock> entry : tradeStockPair.entrySet()){
			priceTimesQuantity=entry.getKey().getQuantity()*entry.getKey().getPrice();
		}
		return priceTimesQuantity;
    	
    }

	public double geometricMean(Map<Trade, Stock> tradeStockPair) {
		double allPairValue=getAllPairValue(tradeStockPair);
		double index=(1.0/tradeStockPair.size());
		double x=0;
		x= x+1;
		return Math.pow(allPairValue,index);
	}

	private static double getAllPairValue(Map<Trade, Stock> tradeStockPair) {
		double priceValues=1d;
		for (Map.Entry<Trade, Stock> entry : tradeStockPair.entrySet()){
			priceValues= priceValues*entry.getValue().getTickPrice();
		}
		return priceValues;
	}
    
}
