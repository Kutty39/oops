package com.blbz.stock.serviceimpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.blbz.stock.model.StockDetails;
import com.blbz.stock.repositry.Repositry;
import com.blbz.stock.service.StockAccService;
import com.blbz.stock.service.StockService;
import com.blbz.stock.utilRepo.Util;

public class StockAccount implements StockAccService {
	Repositry rp = new Repositry();
	StockDetails sd = new StockDetails();
	Util utility = new Util();
	StockService ssc = new StockServImpl();

	@SuppressWarnings({ "unchecked", "static-access", "resource" })
	public void stockAccount(String fileName) {
		JSONObject obj = new JSONObject();
		if (!openJsonfile(fileName)) {
			System.out.println("enter the amount..");
			double amount = utility.longInput();
			obj.put("Initial Amount", amount);
			obj.put("Accountant Name", fileName);
			JSONObject obj1 = new JSONObject();
			JSONArray ar = new JSONArray();
			obj.put("Holdings", obj1);
			obj.put("Transaction", ar);

			try {
				FileWriter fw = new FileWriter("stock/" + fileName + ".json");
				fw.write(obj.toJSONString());
				fw.flush();
				openJsonfile(fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("this file already exits..\nenter new name..");
		}
	}

	public boolean openJsonfile(String file) {
		File f = new File("stock/" + file + ".json");
		if (f.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("stock/" + file + ".json"));
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(br);
				JSONObject jobj = (JSONObject) obj;
				sd.setJsonobj(jobj);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	public double valueOf() {

		return (double) sd.getJsonobj().get("Initial Amount");

	}

	@SuppressWarnings("unchecked")
	public void buy(double amount, String symbol) {
		double d = (double) sd.getJsonobj().get("Initial Amount");
        
		Iterator it = rp.readJson().iterator();
		while (it.hasNext()) {
			JSONObject jobj = (JSONObject) it.next();
			jobj.forEach((k,v)->{
				if(k.equals(symbol))
				{
                 double sharePrice = (double)jobj.get("Share Price");
                 System.out.println(sharePrice);
				// int noOfShares = amount/
				  
				  
				}
			});			

		}

	}

}