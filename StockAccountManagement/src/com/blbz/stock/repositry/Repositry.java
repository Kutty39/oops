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
	public JSONObject readJson() {
		JSONObject jobj1 = null;
	
		JSONParser parser = new JSONParser();
		try {
			BufferedReader br= new BufferedReader(new FileReader("stock/stock.json"));
			jobj1 = (JSONObject) parser.parse(br);
		
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
		return jobj1;     
	}
}
