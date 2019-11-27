package com.blbz.clinique.controller;

import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main 
{
@SuppressWarnings("unchecked")
public static void main(String[] args) 
{
	JSONObject obj = new JSONObject();
	obj.put("Doctor Id", "Dr11");
    obj.put("doctorName", "shivani");
	obj.put("sepcialization", "Ent");
    obj.put("available Timings", "3Pm to 8Pm");
    
    JSONArray arr = new JSONArray();
    arr.add(obj);
    JSONObject jsobj1 = new JSONObject();
	jsobj1.put("Patient Id", "PA02");
	jsobj1.put("patient Name", "mental");
	jsobj1.put("Patient Mobile No", "896765324");
	jsobj1.put("Patient Age", "40y");
	JSONArray arr1 = new JSONArray();
    arr1.add(jsobj1);
	
    JSONObject o1 = new JSONObject();
    o1.put("Date", "26th nov");
	o1.put("availableTime", "2Pm to 3Pm");
	JSONArray arr3 = new JSONArray();
	arr3.add("1");
	o1.put("Patient Id", arr3);
	o1.put("Doctor Id","Dr33");
	 JSONArray arr2 = new JSONArray();
	 arr2.add(o1);
	JSONObject jobj = new JSONObject();
	jobj.put("Book Appointment", arr2);
	jobj.put("Doctors Details", arr);
	jobj.put("Patient Details", arr1);
	 try {
   	  FileWriter fw = new FileWriter("clinical/clinique.json");
   	  fw.write(jobj.toJSONString());
   	  fw.close();
     }catch(Exception e) {
   	  e.printStackTrace();
     }
}
}
