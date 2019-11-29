package com.blbz.stock.controller;

import com.blbz.stock.service.StockAccService;
import com.blbz.stock.serviceimpl.StockAccount;
import com.blbz.stock.utilRepo.Util;

public class StockAccountMain {
	

@SuppressWarnings("static-access")
public static void main(String[] args) {
	 StockAccService sc = new StockAccount();
	Util utility = new Util();

int option = 0;
do {
	System.out.println("chooce the choice..");
	System.out.println("1.create stock Acount..");
	System.out.println("2.login to stock account..");
	System.out.println("3.company details.");
	System.out.println("4.exit");
	option = utility.integerInput();
	switch(option) {
	case 1:
		System.out.println("enter the name to create account..");
		String fileName = utility.stringInput();
		sc.stockAccount(fileName);
		break;
	case 2:
		System.out.println("enter your name to login..");
		String file = utility.stringInput();
		sc.openJsonfile(file);
		System.out.println("--------------------------------------");
		System.out.println("\tcustomer requirements");
		System.out.println("--------------------------------------");
		System.out.println("--> press 1 to show Amount..");
		System.out.println("--> press 2 to buy shares..");
		System.out.println("--> press 3 to sell the shares..");
		int choice = utility.integerInput();
		switch(choice) {
		case 1:
			System.out.println("currently available amount in your account is **"+sc.valueOf()+"**");
		
			break;
		case 2:
			System.out.println("enter amount to buy shares..");
			
			double amount;
			do {
				amount = utility.doublInput();
				if(amount<sc.valueOf())
				{
				System.out.println("enter the company symbol..");
				String symbol = utility.stringInput();		
				sc.buy(amount, symbol);
				}
				else {
					System.out.println("you don't have enough amount..");
				}
			}while(amount > sc.valueOf());
			
		

			break;
		case 3:
			System.out.println();
			break;
		}
		break;
	case 3:
		System.out.println("company details..");
		break;
	case 4:
		System.out.println("completed..");
		break;
	default:
		System.out.println("wrong choice..");
	}
	
}while(option != 4);

}
}
