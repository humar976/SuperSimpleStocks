package com.jpmorgan.supersimplestocks.implementations;

import java.util.Date;
import java.util.TreeMap;

import com.jpmorgan.supersimplestocks.enums.StockType;
import com.jpmorgan.supersimplestocks.structures.Stock;
import com.jpmorgan.supersimplestocks.structures.Trade;

/**
 * @author humar
 *
 */
public class StockImpl implements Stock {
	 /**
 	  * Stock symbol.
 	  */
   private String stockSymbol;

   /**
 	  * Stock type.
 	  */
   private StockType stockType;
 
   /**
    * Stock last dividend.
    */
   private Double lastDividend;
 
   /**
    * Stock fixed dividend.
    */
   private Double fixedDividend;
 
   /**
    * Stock par value.
    */
   private Double parValue;
 
   /**
    * Stock ticker price.
    */
   private Double tickerPrice;
   /**
    * Map of trades on the stock
    */
   private TreeMap<Date, Trade> trades;
 
   /**
    * Default constructor.
    */
   public StockImpl() {
     
   }
 
	 /**
	  * Constructor with all properties.
	  * @param stockSymbol
	  * @param stockType
	  * @param lastDividend
	  * @param fixedDividend
	  * @param parValue
	  * @param tickerPrice
	  */
   public StockImpl(String stockSymbol,StockType stockType,Double lastDividend,Double fixedDividend,Double parValue,Double tickerPrice) {
     
       this.stockSymbol = stockSymbol;
       this.stockType = stockType;
       this.lastDividend = lastDividend;
	   this.fixedDividend = fixedDividend;
	   this.parValue = parValue;
       this.tickerPrice = tickerPrice;
   }
	@Override
	public String getStockSymbol() {
		return this.stockSymbol;
	}

	@Override
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
		
	}

	@Override
	public StockType getStockType() {
		return this.stockType;
	}

	@Override
	public void setStockType(StockType stockType) {
		this.stockType = stockType;
		
	}

	@Override
	public Double getLastDividend() {
		return this.lastDividend;
	}

	@Override
	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
		
	}

	@Override
	public Double getFixedDividend() {
		return this.fixedDividend;
	}

	@Override
	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
		
	}

	@Override
	public Double getParValue() {
		return this.parValue;
	}

	@Override
	public void setParValue(Double parValue) {
		this.parValue = parValue;
		
	}

	@Override
	public Double getTickerPrice() {
		return this.tickerPrice;
	}

	@Override
	public void setTickerPrice(Double tickerPrice) {
		this.tickerPrice = tickerPrice;
		
	}

	/**
	 * @return the trades
	 */
	public TreeMap<Date, Trade> getTrades() {
		return this.trades;
	}

	/**
	 * @param trades the trades to set
	 */
	public void setTrades(TreeMap<Date, Trade> trades) {
		this.trades = trades;
	}

}
