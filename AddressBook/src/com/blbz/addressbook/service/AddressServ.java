package com.blbz.addressbook.service;

public interface AddressServ 
{
    void writeDetails(String fName, String lName, long phoneNum, String city, 
			String state, int zipCode);
	void addDetails();
	void deleteByName(String fName);
	 void searchByName(String fName);
	 void editByName(String fName);
	 
	
}
