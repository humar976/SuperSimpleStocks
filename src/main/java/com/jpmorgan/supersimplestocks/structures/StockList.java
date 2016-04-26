package com.jpmorgan.supersimplestocks.structures;

import java.util.HashMap;

/**
 * @author humar
 *
 */
public interface StockList {
	/**
	 * @return the stocks
	 */	
	HashMap<String, Stock> getStocks();

	/**
	 * @param stocks the stocks to set
	 */
	void setStocks(HashMap<String, Stock> stocks); 
}
