package com.jpmorgan.supersimplestocks.structures;

import java.util.Date;
import java.util.TreeMap;

import com.jpmorgan.supersimplestocks.enums.StockType;

/**
 * @author humar
 *
 */
public interface Stock {
 	 /**
 	  * @return stock's symbol
 	  */
	String getStockSymbol();
 
 	 /**
 	  * @param stockSymbol stock's symbol
 	  */
	void setStockSymbol(String stockSymbol);

   /**
 	  * @return stock's type
 	  */
	StockType getStockType();

	/**
 	  * @param stockType stock's type
 	  */
	void setStockType(StockType stockType);


	/**
 	  * @return stock's last dividend
 	  */
	Double getLastDividend();

	/**
 	  * @param lastDividend stock's last dividend
 	  */
	void setLastDividend(Double lastDividend);

   /**
 	  * @return stock's fixed dividend
 	  */
	Double getFixedDividend();

	/**
 	  * @param fixedDividend stock's fixed dividend
 	  */
	void setFixedDividend(Double fixedDividend);

 
	/**
 	  * @return stock's par value
 	  */
	Double getParValue();

	/**
 	  * @param stocks par value
 	  */
	void setParValue(Double parValue);
 
	/**
 	  * @return stock's ticker price
 	  */
	Double getTickerPrice();

	/**
 	  * @param stock's ticker price
 	  */
   	void setTickerPrice(Double tickerPrice);
	/**
	  * @return Map of trades on the stock
	  */
   	TreeMap<Date,Trade> getTrades();
	/**
	  * @param Map of trades on the stock
	  */
   	void setTrades(TreeMap<Date, Trade> trades);
}
