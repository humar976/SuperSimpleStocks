/**
 * 
 */
package com.jpmorgan.supersimplestocks;

import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpmorgan.supersimplestocks.enums.TradeType;
import com.jpmorgan.supersimplestocks.implementations.StockFunctionsImpl;
import com.jpmorgan.supersimplestocks.implementations.StockImpl;
import com.jpmorgan.supersimplestocks.implementations.StockListImpl;
import com.jpmorgan.supersimplestocks.implementations.TradeImpl;
import com.jpmorgan.supersimplestocks.structures.Stock;
import com.jpmorgan.supersimplestocks.structures.StockFunctions;
import com.jpmorgan.supersimplestocks.structures.StockList;
import com.jpmorgan.supersimplestocks.structures.Trade;

/**
 * @author humar
 *
 */
public class StockFunctionsImplTest {
	@Test
	public void springbeansnotnullTest(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
    	
    	StockList stockList = (StockListImpl) context.getBean("stocksList");
    	Assert.assertNotNull(stockList);
	}
	
	@Test
	public void calcDividendYieldTest(){
		try{
			StockFunctions stockFunctions = new StockFunctionsImpl();
			ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
	    	
	    	Stock stock = (StockImpl) context.getBean("tea");
	    	stock.setTickerPrice(9.1);
	    	Assert.assertTrue(stockFunctions.calcDividendYield(stock) >= 0.0);
		}
		catch(Exception exception){
			Assert.assertTrue(false);
		}
		
	}
	@Test
	public void calcPERatioTest(){
		try{
			StockFunctions stockFunctions = new StockFunctionsImpl();
			ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
	    	
	    	Stock stock = (StockImpl) context.getBean("tea");
	    	stock.setTickerPrice(9.1);
	    	Assert.assertTrue(stockFunctions.calcPERatio(stock) >= 0.0);
		}
		catch(Exception exception){
			Assert.assertTrue(false);
		}
		
	}
	@Test
	public void calcStockPriceTest(){
		try{
			StockFunctions stockFunctions = new StockFunctionsImpl();
			ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
    		
	    	Stock stock = (StockImpl) context.getBean("tea");
	    	stock.setTickerPrice(9.1);
	    	
	    	TreeMap<Date, Trade> trades = new TreeMap<Date, Trade>();
    		Trade trade = new TradeImpl(stock, TradeType.SELL, new Date(),50, 9.2);
    		trades.put(new Date(), trade);
    		stock.setTrades(trades);
	    	Assert.assertTrue(stockFunctions.calcStockPrice(stock) >= 0.0);
		}
		catch(Exception exception){
			Assert.assertTrue(false);
		}
	}
	@Test
	public void calcAllShareIndex(){
		try{
			StockFunctions stockFunctions = new StockFunctionsImpl();
			ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
			HashMap<String, Stock> stocks = new HashMap<String, Stock>();
			
	    	Stock stock1 = (StockImpl) context.getBean("tea");
	    	stock1.setTickerPrice(9.1);
	    	
	    	Stock stock2 = (StockImpl) context.getBean("pop");
	    	stock2.setTickerPrice(9.2);
	    	
	    	TreeMap<Date, Trade> trades1 = new TreeMap<Date, Trade>();
    		Trade trade1 = new TradeImpl(stock1, TradeType.SELL, new Date(),50, 9.2);
    		trades1.put(new Date(), trade1);
    		stock1.setTrades(trades1);
    		
    		TreeMap<Date, Trade> trades2 = new TreeMap<Date, Trade>();
    		Trade trade2 = new TradeImpl(stock2, TradeType.BUY, new Date(),100, 9.4);
    		trades2.put(new Date(), trade2);
    		stock2.setTrades(trades2);
    		
    		stocks.put("TEA",stock1);
    		stocks.put("POP", stock2);
    		
	    	Assert.assertTrue(stockFunctions.calcAllShareIndex(stocks) >= 0.0);
		}
		catch(Exception exception){
			Assert.assertTrue(false);
		}
	}
}
