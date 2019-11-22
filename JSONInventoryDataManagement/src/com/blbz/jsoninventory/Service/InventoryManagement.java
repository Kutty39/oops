package com.blbz.jsoninventory.Service;

import org.json.simple.JSONArray;

import com.blbz.jsoninventory.model.IneventoryDetails;

public interface InventoryManagement {
	void addInventory(String item);

	void writeInventory(String item, String itemName, double itemWeight, double itemPricePerKg);

	double readInventory(String choice);

	double calTotal(JSONArray array);

}
