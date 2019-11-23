package com.blbz.addressbook.serviceimpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.blbz.addressbook.model.AddressBook;
import com.blbz.addressbook.model.Person;
import com.blbz.addressbook.service.AddressServ;
import com.blbz.addressbook.utilrepositry.Utility;

public class ServiceImpl implements AddressServ {
	Utility utility = new Utility();

	public void writeDetails(String fName, String lName, long phoneNum, String city, String state, int zipCode) {
		JSONParser parser = new JSONParser();
		try {
			FileReader fr = new FileReader("address/address.json");
			Object obj = parser.parse(fr);
			JSONObject jobj = (JSONObject) obj;
			JSONArray arr = new JSONArray();
			JSONObject jobj1 = new JSONObject();
			jobj1.put("fName", fName);
			jobj1.put("lName", lName);
			jobj1.put("phoneNum", phoneNum);
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
			System.out.println(e);
		}

	}

	public void addDetails() {
		Person person = new Person();
		AddressBook addres = new AddressBook();

		System.out.println("enter the firstName:");
		person.setfName(utility.stringInput());

		System.out.println("enter the lastName: ");
		person.setlName(utility.stringInput());

		System.out.println("enter the phoneNumber: ");
		person.setPhoneNum(utility.longInput());

		System.out.println("enter the city: ");
		addres.setCity(utility.stringInput());

		System.out.println("enter the State: ");
		addres.setState(utility.stringInput());

		System.out.println("enter the zipcode");
		addres.setZipCode(utility.integerInput());
		writeDetails(person.getfName(), person.getlName(), person.getPhoneNum(), addres.getCity(), addres.getState(),
				addres.getZipCode());
	}

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

	public void searchByName(String fname) {
		JSONParser parser = new JSONParser();
		try {
			BufferedReader br = new BufferedReader(new FileReader("address/address.json"));
			Object obj = parser.parse(br);
			JSONObject jsonbj = (JSONObject) obj;
			JSONArray array = (JSONArray) jsonbj.get(fname);
			Iterator it = array.iterator();
			while (it.hasNext()) {
				JSONObject newobj = (JSONObject) it.next();
				newobj.forEach((k, v) -> System.out.println(k + "\t:\t" + v));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public void editByName(String fName)
	{
		JSONParser parser = new JSONParser();
     try {
    	 BufferedReader br = new BufferedReader(new FileReader("address/address.json"));
		 Object obj = parser.parse(br);
	     JSONObject jsonbj = (JSONObject) obj;
	     
     }catch(Exception e)
     {
    	 e.printStackTrace();
    	 System.out.println(e);
     }
	}
}
