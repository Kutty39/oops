package src.com.blbz.addressbook.controller;
/*
 * created by  : kavya varma
 * created date: 23-11-2019
 * purpose     : user interface for address book
 */
import src.com.blbz.addressbook.serviceimpl.ServiceImpl;

import src.com.blbz.addressbook.utilrepositry.Utility;

public class AddressMain {

	public static void main(String[] args) {
		ServiceImpl adrs = new ServiceImpl();
		Utility utility = new Utility();

		int choice = 0;
		while (choice != 6) {
			System.out.println("*******************************************");
			System.out.println("chooce the choice....");
			System.out.println("1-> add and save details ");
			System.out.println("2-> edit the details ");
			System.out.println("3-> delete the details ");
			System.out.println("4-> search the details ");
			System.out.println("5-> save as the details ");
			System.out.println("6-> exit from this!!!!!!.. ");
			choice = utility.integerInput();
			switch (choice) {
			case 1:
				System.out.println("please add the details one by one....");
				adrs.addDetails();
				break;
			case 2:
				System.out.println("edit the deatails ");
				String fame = utility.stringInput();
				adrs.editByName(fame);
				break;
			case 3:
				System.out.println("enter the name u want to delete..");
				String fName = utility.stringInput();
				adrs.deleteByName(fName);
				break;
			case 4:
				System.out.println("enter the name u want to search ");
				String fname = utility.stringInput();
				adrs.searchByName(fname);
				break;
			case 5:
				System.out.println("save as the details..");
				adrs.saveAsName();
				break;
			case 6:
				System.out.println("**successfully done with everything***");
				System.out.println("Thank you!...");
				break;
			default:
				System.out.println("wrong choice....");
				break;
			}

		}
	}
}