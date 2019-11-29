package com.blbz.stock.controller;

import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.blbz.stock.service.StockService;
import com.blbz.stock.serviceimpl.StockServImpl;
import com.blbz.stock.utilRepo.Util;

public class StockMain {
	static StockService ss = new StockServImpl();
	static Util utility = new Util();

	public static void main(String[] args) {
         int choice = 0;
         while(choice != 3) {
        System.out.println("\n");
        System.out.println("************************************************");	 
		System.out.println("choose the choice...");
		System.out.println("-----------------------");
		System.out.println("1-> add stock details..");
		System.out.println("2-> to print stock report...");
		System.out.println("3-> exit from here...");
		System.out.println("*************************************************");
		choice = utility.integerInput();
		switch(choice) {
		case 1:
			
			System.out.println("enter the details one by one ");
			ss.addStockDetails();
			break;
		case 2:
			System.out.println("****stock report****");
			ss.stockReport();
			break;
		case 3:
		     System.out.println("successfully done with the every thing..");
		     System.out.println("Thank you...");
		     break;
		default:
			System.out.println("wrong choice..");
			break;
		}
	}
	}
}
