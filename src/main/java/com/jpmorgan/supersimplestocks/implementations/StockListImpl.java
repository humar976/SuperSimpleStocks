package com.jpmorgan.supersimplestocks.implementations;

import java.util.HashMap;

import com.jpmorgan.supersimplestocks.structures.Stock;
import com.jpmorgan.supersimplestocks.structures.StockList;

/**
 * @author humar
 *
 */
public class StockListImpl implements StockList {
	
	private HashMap<String, Stock> stocks = null;
	/**
	 * @return the stocks
	 */
	public HashMap<String, Stock> getStocks() {
		return stocks;
	}

	/**
	 * @param stocks the stocks to set
	 */
	public void setStocks(HashMap<String, Stock> stocks) {
		this.stocks = stocks;
	}
}
