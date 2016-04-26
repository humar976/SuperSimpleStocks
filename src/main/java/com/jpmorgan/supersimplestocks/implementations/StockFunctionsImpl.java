package com.jpmorgan.supersimplestocks.implementations;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.SortedMap;

import org.apache.commons.math3.stat.StatUtils;
import com.jpmorgan.supersimplestocks.enums.StockType;
import com.jpmorgan.supersimplestocks.structures.Stock;
import com.jpmorgan.supersimplestocks.structures.StockFunctions;
import com.jpmorgan.supersimplestocks.structures.Trade;

/**
 * @author humar
 *
 */
public class StockFunctionsImpl implements StockFunctions {

	/* (non-Javadoc)
	 * @see com.jpmorgan.supersimplestocks.structures.StockFunctions#calcDividendYield(java.lang.String)
	 */
	@Override
	public double calcDividendYield(Stock stock) throws Exception {
		if(stock.getTickerPrice() >0.0){
			if(stock.getStockType() == StockType.COMMON){
				return stock.getLastDividend()/stock.getTickerPrice();
			}
			else
				/*stock type is PREFERRED*/
				return (stock.getFixedDividend()*stock.getParValue())/stock.getTickerPrice();
		}

		return 0d;
	}

	/* (non-Javadoc)
	 * @see com.jpmorgan.supersimplestocks.structures.StockFunctions#calcPERatio(java.lang.String)
	 */
	@Override
	public double calcPERatio(Stock stock) throws Exception {
		if(stock.getLastDividend() >0.0)
			return stock.getTickerPrice()/stock.getLastDividend();
		else
			return 0d;
				
	}

	/* (non-Javadoc)
	 * @see com.jpmorgan.supersimplestocks.structures.StockFunctions#calcStockPrice(java.lang.String)
	 */
	@Override
	public double calcStockPrice(Stock stock) throws Exception {
		Double stockPrice = 0d;
		Integer totalQuantity = 0;
		Date currentTime = new Date();
		// 15 minutes earlier
		Date earlierTime = new Date(currentTime.getTime() - (15 * 60 * 1000));
		// Collection of trades in last 15 minutes
		if(!stock.getTrades().isEmpty()){
			SortedMap<Date, Trade> trades = stock.getTrades().tailMap(earlierTime);
			
			for (Trade trade: trades.values()) {
				totalQuantity += trade.getShareQuantity();
				stockPrice += trade.getPrice() * trade.getShareQuantity();
			}
			return stockPrice/totalQuantity;
		}
		else
			return -1d;
		
	}

	/* (non-Javadoc)
	 * @see com.jpmorgan.supersimplestocks.structures.StockFunctions#calcAllShareIndex(com.jpmorgan.supersimplestocks.structures.StockList)
	 */
	@Override
	public double calcAllShareIndex(HashMap<String,Stock> stocks) throws Exception {
		double allShareIndex = 0d;
		
		// Calculate stock price for all stock in the system

		ArrayList<Double> stockPrices = new ArrayList<Double>();
		for(Stock stock: stocks.values()){
			double stockPrice = this.calcStockPrice(stock);
			if(stockPrice > 0){
				stockPrices.add(stockPrice);
			}
		}
		//Putting in Array now as all non-zero values
		if(stockPrices.size()>=1){
			double[] stockPricesArray = new double[stockPrices.size()];
			
			for(int i=0; i<=(stockPrices.size()-1); i++){
				stockPricesArray[i] = stockPrices.get(i).doubleValue();
			}
			
			allShareIndex = StatUtils.geometricMean(stockPricesArray);
		}
		return allShareIndex;
	}

}
