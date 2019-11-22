package com.blbz.jsoninventory.ServiceImplementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.blbz.jsoninventory.Service.InventoryManagement;
import com.blbz.jsoninventory.UtilRepositry.Util;
import com.blbz.jsoninventory.model.IneventoryDetails;

public class InventoryImplementation implements InventoryManagement {
	static Util util = new Util();

	public void writeInventory(String item, String itemName, double itemWeight, double itemPricePerKg) {
		JSONParser parser = new JSONParser();
		try {
			FileReader fr = new FileReader("inventory/inventory.json");
			Object obj = parser.parse(fr);
			JSONObject jsnObj = (JSONObject) obj;
			JSONArray invDetails = (JSONArray) jsnObj.get(item);
			JSONObject obj1 = new JSONObject();
			obj1.put("itemName", itemName);
			obj1.put("itemweight", itemWeight);
			obj1.put("itemPricePerKg", itemPricePerKg);
			invDetails.add(obj1);

			System.out.println(invDetails);
			FileWriter fw = new FileWriter("inventory/inventory.json");
			fw.write(jsnObj.toJSONString());
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public double readInventory(String choice) {
		double total = 0;

		try {
			Object obj = new JSONParser().parse(new FileReader("inventory/inventory.json"));
			JSONObject jo = (JSONObject) obj;
			if (choice.equals("All")) {
				JSONArray array = (JSONArray) jo.get("Rice");
				total = total + calTotal(array);
				array = (JSONArray) jo.get("wheat");
				total = total + calTotal(array);
				array = (JSONArray) jo.get("pulses");
				total = total + calTotal(array);

			} else {
				JSONArray array = (JSONArray) jo.get(choice);
				total = total + calTotal(array);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;

	}

	public double calTotal(JSONArray array) {
		Iterator it = array.iterator();
		double calulation = 0;
		while (it.hasNext()) {
			JSONObject jobj = (JSONObject) it.next();
			double itemWeight = (double) jobj.get("itemweight");
			double itemPricePerKg = (double) jobj.get("itemPricePerKg");
			calulation = calulation + itemWeight * itemPricePerKg;

		}
		return calulation;
	}

	public void addInventory(String item) {
		IneventoryDetails details = new IneventoryDetails();
		System.out.println();
		System.out.println("enter the type of item name ");
		details.setItemName(util.stringInput());

		System.out.println("enter the weight of that item ");
		details.setItemWeight(util.doublInput());

		System.out.println("enter the price per kg of that item ");
		details.setItemPricePerKg(util.doublInput());
		writeInventory(item, details.getItemName(), details.getItemWeight(), details.getItemPricePerKg());
	}
}
