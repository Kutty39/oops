package src.com.blbz.addressbook.serviceimpl;
/*
 * Implemented methods for address book service
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import src.com.blbz.addressbook.utilrepositry.Utility;

import src.com.blbz.addressbook.model.AddressBook;
import src.com.blbz.addressbook.model.Person;
import src.com.blbz.addressbook.service.AddressServ;

public class ServiceImpl implements AddressServ {
	Utility utility = new Utility();

	/*
	 * it will read the json file and add the details to addressbook
	 */
	@SuppressWarnings("unchecked")
	public void writeDetails(String fName, String lName, long phonNo, String city, String state, int zipCode) {
		JSONParser parser = new JSONParser();
		try {
			FileReader fr = new FileReader("address/address.json");
			Object obj = parser.parse(fr);
			JSONObject jobj = (JSONObject) obj;
			JSONArray arr = new JSONArray();
			JSONObject jobj1 = new JSONObject();
			jobj1.put("fName", fName);
			jobj1.put("lName", lName);
			jobj1.put("phonNo", phonNo);
			jobj1.put("city", city);
			jobj1.put("state", state);
			jobj1.put("zipCode", zipCode);
			arr.add(jobj1);
			System.out.println(arr);
			jobj.put(fName, arr);
			FileWriter fw = new FileWriter("address/address.json");
			fw.write(jobj.toJSONString());
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
   /*
    * this methos will take details from user and will add and save to address book
    */
	@SuppressWarnings("static-access")
	public void addDetails() {
		Person person = new Person();
		AddressBook addres = new AddressBook();

		System.out.println("enter the firstName:");
		person.setfName(utility.stringInput());

		System.out.println("enter the lastName: ");
		person.setlName(utility.stringInput());

		System.out.println("enter the phoneNumber: ");
		person.setPhonNo(utility.longInput());

		System.out.println("enter the city: ");
		addres.setCity(utility.stringInput());

		System.out.println("enter the State: ");
		addres.setState(utility.stringInput());

		System.out.println("enter the zipcode");
		addres.setZipCode(utility.integerInput());
		writeDetails(person.getfName(), person.getlName(), person.getPhonNo(), addres.getCity(), addres.getState(),
				addres.getZipCode());
	}
/*
 * delete method to delete the details of addressbook
 */
	public void deleteByName(String fName) {
		JSONParser parser = new JSONParser();
		try {
			BufferedReader br = new BufferedReader(new FileReader("address/address.json"));
			Object obj1 = parser.parse(br);
			JSONObject jsobj = (JSONObject) obj1;
			jsobj.get(fName);
			jsobj.remove(fName);
			FileWriter fw = new FileWriter("address/address.json");
			fw.write(jsobj.toJSONString());
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
/*
 * search method to search the details for selected name
 * 
 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void searchByName(String fname) {
		JSONParser parser = new JSONParser();
		try {
			BufferedReader br = new BufferedReader(new FileReader("address/address.json"));
			Object obj = parser.parse(br);
			JSONObject jsonbj = (JSONObject) obj;
			JSONArray array = (JSONArray) jsonbj.get(fname);
			if (array != null) {
				Iterator it = array.iterator();
				while (it.hasNext()) {
					JSONObject newobj = (JSONObject) it.next();

					newobj.forEach((k, v) -> System.out.println(k + "\t:\t" + v));
				}
			} else {
				System.out.println("given name details not available..");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
/*
 * edit method to edit the details for selected name
 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public void editByName(String fName) {
		JSONParser parser = new JSONParser();
		try {
			BufferedReader br = new BufferedReader(new FileReader("address/address.json"));
			Object obj = parser.parse(br);
			JSONObject jsonbj = (JSONObject) obj;
			if (jsonbj.get(fName) != null) {
				JSONArray arr = (JSONArray) jsonbj.get(fName);
				JSONObject finalobj = (JSONObject) arr.get(0);
				finalobj.forEach((k, v) -> {
					if (!k.equals("fName")) {
						System.out.println(k + "\t:\t" + v);
						System.out.println("press 'x' to edit the details or press any key to move next details");
						String s = utility.stringInput();
						if (s.equals("x")) {
							System.out.println("enter the new details..");
							if (k.equals("zipCode") || k.equals("phonNo")) {
								finalobj.put(k, Utility.integerInput());
							} else {
								finalobj.put(k, utility.stringInput());
							}
						}
					}
				});
				System.out.println("after editing, your details are..");
				finalobj.forEach((k, v) -> System.out.println(k + "\t:\t" + v));
				FileWriter fw = new FileWriter("address/address.json");
				fw.write(jsonbj.toJSONString());
				fw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
/*
 * to save the same details into another file based on user requirements
 */
	public void saveAsName() {
		JSONParser parser = new JSONParser();
		try {
			BufferedReader br = new BufferedReader(new FileReader("address/address.json"));
			Object obj = parser.parse(br);
			JSONObject jsonbj = (JSONObject) obj;
			System.out.println("enter the file name you want to save as..");
			String st = Utility.stringInput();
			FileWriter fw = new FileWriter("address/" + st + ".json");
			fw.write(jsonbj.toJSONString());
			fw.close();
		} catch (Exception e) {

		}
	}
}
