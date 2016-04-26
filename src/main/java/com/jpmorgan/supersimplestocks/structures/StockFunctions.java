package com.jpmorgan.supersimplestocks.structures;

import java.util.HashMap;

/**
 * @author humar
 *
 */
public interface StockFunctions {
	public double calcDividendYield(Stock stock) throws Exception;
	public double calcPERatio(Stock stock) throws Exception;
	public double calcStockPrice(Stock stock) throws Exception;
	public double calcAllShareIndex(HashMap<String,Stock> stocks) throws Exception;
}
