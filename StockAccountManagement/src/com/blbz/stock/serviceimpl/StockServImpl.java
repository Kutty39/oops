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

	public void writeStockDetails(String stockName, int noOfShares, double sharePrice) {
		JSONParser parser = new JSONParser();
		try {
			BufferedReader br = new BufferedReader(new FileReader("stock/stock.json"));
			Object obj = parser.parse(br);
			JSONObject jobj = (JSONObject) obj;
			JSONArray arr = (JSONArray) jobj.get("Stock Management");
			JSONObject jsobj = new JSONObject();
			jsobj.put("stockName", stockName);
			jsobj.put("noOfShares", noOfShares);
			jsobj.put("sharePrice", sharePrice);
			jsobj.put("Total", noOfShares * sharePrice);
			arr.add(jsobj);
			FileWriter fw = new FileWriter("stock/stock.json");
			fw.write(jobj.toJSONString());
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public void addStockDetails() {
		StockDetails sd = new StockDetails();
		System.out.println("enter the stock name->");
		sd.setStockName(utility.stringInput());

		System.out.println("enter the noOfShares->");
		sd.setNoOfShares(utility.integerInput());

		System.out.println("enter the share price->");
		sd.setSharePrice(utility.doublInput());
		writeStockDetails(sd.getStockName(), sd.getNoOfShares(), sd.getSharePrice());
	}
	public void stockReport() {
		JSONParser parse = new JSONParser();
		try {
			BufferedReader br = new BufferedReader(new FileReader("stock/stock.json"));
			Object obj = parse.parse(br);
			JSONObject jobj = (JSONObject)obj;
			JSONArray arr = (JSONArray) jobj.get("Stock Management");
			Iterator it = arr.iterator();
		
			System.out.println(" _________________________________________________________________");
			System.out.println("|                                                                 | ");
			System.out.println("|Stock Name \t  Stock Shares \t    Stock Price\t      Total value |   ");
			System.out.println("|_________________________________________________________________|");
			
			while(it.hasNext())
			{
				
				JSONObject jsonbj = (JSONObject)it.next();
				System.out.println();
				System.out.print(" "+jsonbj.get("stockName").toString()+"\t\t");
				System.out.print(jsonbj.get("noOfShares").toString()+"\t\t");
				System.out.print(jsonbj.get("sharePrice").toString()+"\t\t");
				System.out.print(jsonbj.get("Total").toString()+"\t\t");
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
