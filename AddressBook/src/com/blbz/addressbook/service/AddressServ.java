package src.com.blbz.addressbook.service;
/*
 * Interface for adressbook
 */
public interface AddressServ 
{
    void writeDetails(String fName, String lName, long phonNo, String city, 
			String state, int zipCode);
	void addDetails();
	void deleteByName(String fName);
	 void searchByName(String fName);
	 void editByName(String fName);
	 void saveAsName();
	
}
