package com.jpmorgan.supersimplestocks;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpmorgan.supersimplestocks.enums.TradeType;
import com.jpmorgan.supersimplestocks.implementations.StockFunctionsImpl;
import com.jpmorgan.supersimplestocks.implementations.StockListImpl;
import com.jpmorgan.supersimplestocks.implementations.TradeImpl;
import com.jpmorgan.supersimplestocks.structures.Stock;
import com.jpmorgan.supersimplestocks.structures.StockFunctions;
import com.jpmorgan.supersimplestocks.structures.Trade;
import com.jpmorgan.supersimplestocks.structures.StockList;


/**
 * @author humar
 *
 */
public class SuperSimpleStocksApplication {

	public static void main(String[] args) throws Exception {
		
		StockFunctions stockFunctions = new StockFunctionsImpl();
    	ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
    	
    	StockList stockList = (StockListImpl) context.getBean("stocksList");
    	HashMap<String, Stock> stocks = stockList.getStocks();
        
    	/*Recording random number of trades for each stock*/
    	Integer minValue = 1;
        Integer maxValue = 9;
    	for (Stock stock: stocks.values()) {
    		
    		Trade trade = null;
    		TreeMap<Date, Trade> trades = new TreeMap<Date, Trade>();
    		/*generate random number between 0 and 100 to set as total number of trades*/
            
    		Random rand = new Random();
        	int numTrades = rand.nextInt(101);

        	/*start recording 'numTrades' number of trades for 'stock'*/
        	for(int i = 0;i < numTrades;i++){
        		/*randomly select whether buying or selling*/
        		TradeType buyOrSell = rand.nextBoolean()?TradeType.BUY:TradeType.SELL;
        		trade = new TradeImpl(stock, buyOrSell, new Date(), (rand.nextInt(1000)+1),(rand.nextDouble() * (maxValue - minValue) + minValue));
        		trades.put(new Date(), trade);
        	}
        	stock.setTrades(trades);
        	/*if 1 or more trades performed on the stock*/
        	if(trade!=null && trade.getPrice()>0){
        		/*set the ticket price of stock to the last trade price*/
        		stock.setTickerPrice(trade.getPrice());
        		/*Calculate and display stock price based on trades in last 15 mins*/
        		System.out.println("Stock Price of stock " + stock.getStockSymbol() + " is "+ stockFunctions.calcStockPrice(stock)+"\n");
        	}
        	/*if no trade on the stock then set par value as the ticker price*/
        	else{
        		/*set ticker price to the par value of the stock*/
        		stock.setTickerPrice(stock.getParValue());
        		System.out.println("No trade recorded for stock "+ stock.getStockSymbol()+"\n");
        	}
        	
        	/*
        	 * Calculate and display Dividend Yield and PERatio of Stock
        	 */
        	System.out.println("Divident Yield of stock " + stock.getStockSymbol() + " is "+stockFunctions.calcDividendYield(stock)+"\n");
        	System.out.println("PE Ratio of stock " + stock.getStockSymbol() + " is "+stockFunctions.calcPERatio(stock)+"\n");
        	
    	}
    	/*
    	 * Calculate and display AllShareIndex 
    	 */
    	System.out.println("All Share Index for GBCE is " + stockFunctions.calcAllShareIndex(stocks)+"\n");
	}

}
