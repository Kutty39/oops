package com.blbz.stock.serviceimpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
		sd.setFilename("stock/" + fileName + ".json");
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
				FileWriter fw = new FileWriter(sd.getFilename());
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
		sd.setFilename("stock/" + file + ".json");
		File f = new File(sd.getFilename());
		if (f.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(sd.getFilename()));
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
		JSONObject baseobj = (JSONObject) rp.readJson();
		JSONArray arr = (JSONArray) baseobj.get("Stock Management");
		Iterator it = arr.iterator();
		while (it.hasNext()) {
			JSONObject jobj = (JSONObject) it.next();
			jobj.forEach((k, v) -> {
				if (k.equals("Stock Symbol")) {
					if (v.equals(symbol)) {
						double sharePrice = (double) jobj.get("Share Price");
						int cusShares = (int) (amount / sharePrice);
						JSONArray arr2 = (JSONArray) sd.getJsonobj().get("Holdings");
						JSONObject obj2 = new JSONObject();
						obj2.put("No Of Shares", cusShares);
						obj2.put("Stock Symbol", symbol);
						arr2.add(obj2);
						long cmpnyShares = (long) jobj.get("No Of Shares");
						cmpnyShares = cmpnyShares - cusShares;
						jobj.put("No Of Shares", cmpnyShares);
						double cmpamount = (double) jobj.get("Total Amount");
						cmpamount = cmpamount - amount;
						jobj.put("Total Amount", cmpamount);
						double cusAmnt = (double) sd.getJsonobj().get("Initial Amount");
						cusAmnt = cusAmnt - amount;
						sd.getJsonobj().put("Initial Amount", cusAmnt);
						JSONObject jo = new JSONObject();
						JSONArray arr1 = (JSONArray) sd.getJsonobj().get("Transaction");
						jo.put("Shares", cusShares);
						jo.put("Stock Symbol", symbol);
						jo.put("Amount", amount);
						jo.put("Action", "Buy");
						DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy 'At' hh:mm a");
						String date = LocalDateTime.now().format(formater);
						jo.put("Date & Time", date);
						arr1.add(jo);

					}
				}
			});
			try {
				FileWriter fw = new FileWriter("stock/stock.json");
				fw.write(baseobj.toJSONString());
				fw.flush();
				FileWriter fw1 = new FileWriter(sd.getFilename());
				fw1.write(sd.getJsonobj().toJSONString());
				fw1.flush();
			} catch (Exception e) {

			}
		}

	}

	@SuppressWarnings("unchecked")
	public void sell(double amount1, String symbol1) {
		JSONObject baseobj = (JSONObject) rp.readJson();
		JSONArray stk = (JSONArray) baseobj.get("Stock Management");
		Iterator it1 = stk.iterator();
		while(it1.hasNext()) {
			
			JSONObject stkdetail = (JSONObject)it1.next();
			if (stkdetail.get("Stock Symbol").equals(symbol1)) {
				if (stkdetail != null) {
					JSONArray hold = (JSONArray) sd.getJsonobj().get("Holdings");
					Iterator it = hold.iterator();
					while(it.hasNext()){
						JSONObject h1 = (JSONObject)it.next();
						if (h1.get("Stock Symbol").equals(symbol1)) {
							long actamount = (long) ((long) h1.get("No Of Shares") * (double) stkdetail.get("Share Price"));
							if (actamount >= amount1) {
								double sharePrice = (double) stkdetail.get("Share Price");
								double shares = amount1 / sharePrice;
								long cusShares = (long) h1.get("No Of Shares");
								cusShares = (long) (cusShares - shares);
								h1.put("No Of Shares", cusShares);
								long stkShares = (long) stkdetail.get("No Of Shares");
								stkShares = (long) (stkShares + shares);
								stkdetail.put("No Of Shares", stkShares);
								double stkamount = (double) stkdetail.get("Total Amount");
								stkamount = stkamount + amount1;
								stkdetail.put("Total Amount", stkamount);
								double cusamount = (double)  sd.getJsonobj().get("Initial Amount");
								cusamount = (long) (cusamount + amount1);
								sd.getJsonobj().put("Initial Amount", cusamount);
								//hold.add(h1);
								JSONArray holdTrn = (JSONArray) sd.getJsonobj().get("Transaction");
								JSONObject jjobj = new JSONObject();
								jjobj.put("Shares", cusShares);
								jjobj.put("Stock Symbol", symbol1);
								jjobj.put("Amount", amount1);
								jjobj.put("Action", "sell");
								DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy 'At' hh:mm a");
								String date = LocalDateTime.now().format(formater);
								jjobj.put("Date & Time", date);
								holdTrn.add(jjobj);
								break;
							}
						}

					}
				}
			break;
			}
		}

		try {
			FileWriter fw = new FileWriter("stock/stock.json");
			fw.write(baseobj.toJSONString());
			fw.flush();
			FileWriter fw1 = new FileWriter(sd.getFilename());
			fw1.write(sd.getJsonobj().toJSONString());
			fw1.flush();
		} catch (Exception e) {

		}
	}
}