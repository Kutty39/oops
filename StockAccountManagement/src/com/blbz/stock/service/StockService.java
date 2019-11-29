package com.blbz.stock.service;

public interface StockService 
{
	void writeStockDetails(String stockName, int noOfShares, double sharePrice, String stockSymbol);
	void addStockDetails();
	void stockReport();
}
