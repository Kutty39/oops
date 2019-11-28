package com.blbz.clinique.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface CliniqueServ 
{
void writeDetails(String details,String dId, String doctorName, String specialization, String availableTime);
void writePatientDetails(String details,String pId, String pName, long mobNo, String age);
void addDoctorDetails(String details);
void addPatientDetails(String details);
void  showingDoctorDetails();
boolean searchDetails(String Id, String pId,String temp2);
public JSONObject searchDetailsandget(String Id, String temp,String temp2,JSONObject jsonbj);


}
