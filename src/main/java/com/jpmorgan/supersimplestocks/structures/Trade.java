package com.jpmorgan.supersimplestocks.structures;

import java.util.Date;

import com.jpmorgan.supersimplestocks.enums.TradeType;

/**
 * @author humar
 *
 */
public interface Trade {
    /**
  	  * @return trade's stock
  	  */
  	 Stock getStock();
  
  	 /**
  	  * @param stock trade's stock
  	  */
    void setStock(Stock stock);

  	 /**
  	  * @return trade's timestamp
  	  */
  	 Date getTimestamp();
  
  	 /**
  	  * @param timestamp trade's timestamp
  	  */
    void setTimestamp(Date timestamp);

    /**
  	  * @return trade's share quantity
  	  */
    Integer getShareQuantity();
  
  	 /**
  	  * @param sharesQuantity trade's share quantity
  	  */
    void setShareQuantity(Integer shareQuantity);

    /**
  	  * @return type : BUY or SELL
  	  */
    TradeType getType();
  
  	 /**
  	  * @param type BUY or SELL
  	  */
    void setType(TradeType type);

    /**
  	  * @return trade's price
  	  */
    Double getPrice();
  
  	 /**
  	  * @param price trade's price
  	  */
    void setPrice(Double price);

}
