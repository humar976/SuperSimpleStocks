package com.jpmorgan.supersimplestocks.implementations;

import java.util.Date;

import com.jpmorgan.supersimplestocks.enums.TradeType;
import com.jpmorgan.supersimplestocks.structures.Stock;
import com.jpmorgan.supersimplestocks.structures.Trade;

/**
 * @author humar
 *
 */
public class TradeImpl implements Trade {


	/*
 	 * Stock.
 	 */
   private Stock stock;
  
   /*
    * Trade type: Buy or sell.
    */
   private TradeType type;
   
   /*
    * Timestamp of the trade.
    */
   private Date timestamp;

   /*
    * Share quantity of trade.
    */
   private Integer shareQuantity;

   /*
 	  * Trade's price.
 	  */
   private Double price;

 	 /**
 	  * Default constructor.
 	  */
   public TradeImpl() {
     
   }
 
   /**
    * Constructor with all properties.
    * @param stock
    * @param type
    * @param timestamp
    * @param shareQuantity
    * @param price
    */
   public TradeImpl(Stock stock,TradeType type,Date timestamp,Integer shareQuantity,Double price) {
     
       this.stock = stock;
       this.type = type;
       this.timestamp = timestamp;
       this.shareQuantity = shareQuantity;
       this.price = price;
   }
 
   @Override
 	 public Stock getStock() {
     
       return this.stock;
   }
 
   @Override
   public void setStock(Stock stock) {
     
       this.stock = stock;
   }
   
   @Override
   public TradeType getType() {
     
       return this.type;
   }
 
   @Override
   public void setType(TradeType type) {
     
       this.type = type;
   } 
   
   @Override
 	 public Date getTimestamp() {
     
       return this.timestamp;
   }
 
   @Override
   public void setTimestamp(Date timestamp) {
     
       this.timestamp = timestamp;
   }

   @Override
   public Integer getShareQuantity() {
     
       return this.shareQuantity;
   }
 
   @Override
   public void setShareQuantity(Integer shareQuantity) {
     
       this.shareQuantity = shareQuantity;
   }


   @Override
   public Double getPrice() {
     
       return this.price;
   }
 
   @Override
   public void setPrice(Double price) {
     
       this.price = price;
   }


}
