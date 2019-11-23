package com.blbz.addressbook.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.blbz.addressbook.serviceimpl.ServiceImpl;
import com.blbz.addressbook.utilrepositry.Utility;

public class AddressMain
{

public static void main(String[] args) {
	 ServiceImpl adrs = new ServiceImpl();
	 Utility utility = new Utility();
	 
	 int choice = 0;
	 while(choice != 7)
	 {
	 System.out.println("chooce the choice....");
	 System.out.println("1. add details ");
	 System.out.println("2. edit the details ");
	 System.out.println("3. delete the details ");
	 System.out.println("4. search the details ");
	 System.out.println("5. save the deatails");
	 System.out.println("6. save as the details ");
	 System.out.println("7. exit from this!!!!!!.. ");
	 choice = utility.integerInput();
	 switch(choice) {
	 case 1:
		 System.out.println("please add the details one by one....");
		 adrs.addDetails();
		 break;
	 case 2:
		 System.out.println("edit the deatails ");
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
	default:
		System.out.println("wrong choice....");
		break;
	 }
 
	 
	 }
}
}