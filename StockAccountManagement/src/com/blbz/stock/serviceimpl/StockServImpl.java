package com.blbz.stock.serviceimpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.blbz.stock.model.StockDetails;
import com.blbz.stock.service.StockService;
import com.blbz.stock.utilRepo.Util;

public class StockServImpl implements StockService {
	Util utility = new Util();

	@SuppressWarnings("unchecked")
	public void writeStockDetails(String stockName, int noOfShares, double sharePrice, String stockSymbol) {
		JSONParser parser = new JSONParser();
		try {
			BufferedReader br = new BufferedReader(new FileReader("stock/stock.json"));
			Object obj = parser.parse(br);
			JSONObject jobj = (JSONObject) obj;
			JSONArray arr = (JSONArray) jobj.get("Stock Management");
			JSONObject jsobj = new JSONObject();
			jsobj.put("Stock Name", stockName);
			jsobj.put("Stock Symbol", stockSymbol);
			jsobj.put("No Of Shares", noOfShares);
			jsobj.put("Share Price", sharePrice);
			jsobj.put("Total Amount", noOfShares * sharePrice);
			arr.add(jsobj);
			FileWriter fw = new FileWriter("stock/stock.json");
			fw.write(jobj.toJSONString());
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	@SuppressWarnings("static-access")
	public void addStockDetails() {
		StockDetails sd = new StockDetails();
		System.out.println("enter the stock name->");
		sd.setStockName(utility.stringInput());
        
		System.out.println("enter the stock symbol->");
		sd.setStockSymbol(utility.stringInput());
		System.out.println("enter the noOfShares->");
		sd.setNoOfShares(utility.integerInput());

		System.out.println("enter the share price->");
		sd.setSharePrice(utility.doublInput());
		writeStockDetails(sd.getStockName(), sd.getNoOfShares(), sd.getSharePrice(),sd.getStockSymbol());
	}

	@SuppressWarnings("rawtypes")
	public void stockReport() {
		JSONParser parse = new JSONParser();
		try {
			BufferedReader br = new BufferedReader(new FileReader("stock/stock.json"));
			Object obj = parse.parse(br);
			JSONObject jobj = (JSONObject) obj;
			JSONArray arr = (JSONArray) jobj.get("Stock Management");
			Iterator it = arr.iterator();

			System.out.println(" ________________________________________________________________________________");
			System.out.println("|                                                                                | ");
			System.out.println("|Stock Name \t Stock Symbol \t Stock Shares \t    Stock Price\t     Total Amount|   ");
			System.out.println("|________________________________________________________________________________|");

			while (it.hasNext()) {

				JSONObject jsonbj = (JSONObject) it.next();
				System.out.println();
				System.out.print(" " + jsonbj.get("Stock Name").toString() + "\t\t");
				System.out.print(jsonbj.get("Stock Symbol").toString() +"\t\t");
				System.out.print(jsonbj.get("No Of Shares").toString() + "\t\t");
				System.out.print(jsonbj.get("Share Price").toString() + "\t\t");
				System.out.print(jsonbj.get("Total Amount").toString() + "\t\t");

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
