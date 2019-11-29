package com.blbz.stock.repositry;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.blbz.stock.model.StockDetails;

public class Repositry 
{
	StockDetails sd = new StockDetails();
	public JSONArray readJson() {
		JSONArray arr = null;
		JSONParser parser = new JSONParser();
		try {
			BufferedReader br= new BufferedReader(new FileReader("stock/stock.json"));
			Object obj = parser.parse(br);
			JSONObject jobj = (JSONObject)obj;
			arr = (JSONArray)jobj.get("Stock Management");
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
		return arr;     
	}
}
