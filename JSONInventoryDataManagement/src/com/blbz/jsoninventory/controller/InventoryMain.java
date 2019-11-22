package com.blbz.jsoninventory.controller;

import com.blbz.jsoninventory.Service.InventoryManagement;
import com.blbz.jsoninventory.ServiceImplementation.InventoryImplementation;
import com.blbz.jsoninventory.UtilRepositry.Util;

public class InventoryMain {
	public static void main(String[] args) {
		Util utility = new Util();
		InventoryImplementation inv = new InventoryImplementation();
		int option = 0;
		while (option != 3) {
			System.out.println("enter the option.... ");
			System.out.println("1 for add the details.. ");
			System.out.println("2 for caluculation... ");
			System.out.println("3 for exit..");
			System.out.println("please enter the option ");
			option = utility.integerInput();
			switch (option) {
			case 1:
				System.out.println("select the option for which type of product you want ");
				System.out.println("\n 1 for Rice ");
				System.out.println("\n 2 for Wheats ");
				System.out.println("\n 3 for pulses ");
				System.out.println("\nplease enter the product choice ");
				int productOpt = utility.integerInput();
				switch (productOpt) {
				case 1:
					System.out.println("add rice details ");
					inv.addInventory("Rice");

					break;
				case 2:
					System.out.println("add wheat details ");
					inv.addInventory("wheat");

					break;
				case 3:
					System.out.println("add pulses details ");
					inv.addInventory("pulses");

					break;
				default:
					System.out.println("wrong choice");
					break;

				}
				break;

			case 2:
				System.out.println("select the calculation choice ");
				System.out.println("1 for rice calulation ");
				System.out.println("2 for wheat calculation ");
				System.out.println("3 for pulses calculation ");
				System.out.println("4 for all ");
				int choice = utility.integerInput();
				switch (choice) {
				case 1:
					System.out.println("calulation for rice");
					System.out.println(inv.readInventory("Rice"));
					break;
				case 2:
					System.out.println("calculation for wheat ");
					System.out.println(inv.readInventory("Pulses"));

					break;
				case 3:
					System.out.println("calculation for pulses ");
					System.out.println(inv.readInventory("wheat"));

					break;
				case 4:
					System.out.println("calculation for all ");
					System.out.println(inv.readInventory("All"));
					break;

				default:
					System.out.println("wrong choice");
					break;
				}
				break;
			default:
				System.out.println("wrong choice");
				break;
			}
		}
	}
}
