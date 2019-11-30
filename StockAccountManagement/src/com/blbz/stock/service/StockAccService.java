package com.blbz.stock.service;

public interface StockAccService {
	void stockAccount(String fileName);
	boolean openJsonfile(String file);
	double valueOf();
	void buy(double amount, String fileName);
    void sell(double amount1, String symbol1);
	
}
