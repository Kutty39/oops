package com.blbz.stock.service;

public interface StockService 
{
	void writeStockDetails(String stockName, int noOfShares, double sharePrice);
	void addStockDetails();
	void stockReport();
}
