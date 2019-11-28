package com.blbz.clinique.serviceImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.blbz.clinique.model.DoctorDetails;
import com.blbz.clinique.model.PatientDetails;
import com.blbz.clinique.service.CliniqueServ;
import com.blbz.clinique.utilRepositry.Utility;

public class CliniqueServImpl implements CliniqueServ {
	Utility utility = new Utility();

	@SuppressWarnings("unchecked")
	@Override
	public void writeDetails(String details, String dId, String doctorName, String specialization,
			String availableTime) {
		JSONParser parser = new JSONParser();
		try (BufferedReader br = new BufferedReader(new FileReader("clinical/clinique.json"))) {
			Object obj = parser.parse(br);
			JSONObject jobj = (JSONObject) obj;
			JSONArray arr = (JSONArray) jobj.get(details);
			JSONObject jsobj = new JSONObject();
			jsobj.put("Doctor Id", "Dr" + dId);
			jsobj.put("doctorName", doctorName);
			jsobj.put("sepcialization", specialization);
			jsobj.put("available Timings", availableTime);

			arr.add(jsobj);
			FileWriter fw = new FileWriter("clinical/clinique.json");
			fw.write(jobj.toJSONString());
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	public void writePatientDetails(String details, String pId, String pName, long mobNo, String age) {
		JSONParser parser = new JSONParser();
		try (BufferedReader br = new BufferedReader(new FileReader("clinical/clinique.json"))) {
			Object obj = parser.parse(br);
			JSONObject jobj = (JSONObject) obj;
			JSONArray arr1 = (JSONArray) jobj.get(details);
			JSONObject jsobj1 = new JSONObject();
			jsobj1.put("Patient Id", "PA" + pId);
			jsobj1.put("patient Name", pName);
			jsobj1.put("Patient Mobile No", mobNo);
			jsobj1.put("Patient Age", age);
			arr1.add(jsobj1);
			FileWriter fw = new FileWriter("clinical/clinique.json");
			fw.write(jobj.toJSONString());
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

	@SuppressWarnings("static-access")
	@Override
	public void addDoctorDetails(String details) {
		DoctorDetails dd = new DoctorDetails();
		System.out.println("enter the doctor id..");
		dd.setdId(utility.stringInput());

		System.out.println("enter the name of the doctor: ");
		dd.setDoctorName(utility.stringInput());

		System.out.println("enter the doctor specialization: ");
		dd.setSpecialization(utility.stringInput());

		System.out.println("enter the available time: ");
		dd.setAvailableTime(utility.stringInput());

		writeDetails(details, dd.getdId(), dd.getDoctorName(), dd.getSpecialization(), dd.getAvailableTime());
	}

	@SuppressWarnings("static-access")
	public void addPatientDetails(String details) {
		PatientDetails pd = new PatientDetails();
		System.out.println("enter the patient id..");
		pd.setpId(utility.stringInput());
		System.out.println("enter the name of patient: ");
		pd.setpName(utility.stringInput());

		System.out.println("enter the patient age: ");
		pd.setAge(utility.stringInput());

		System.out.println("enter the mobile patient number: ");
		pd.setMobNo(utility.longInput());
		writePatientDetails(details, pd.getpId(), pd.getpName(), pd.getMobNo(), pd.getAge());
	}

	@SuppressWarnings("unchecked")
	public void showingDoctorDetails() {
		JSONParser parser = new JSONParser();
		try (BufferedReader br = new BufferedReader(new FileReader("clinical/clinique.json"))) {
			Object obj = parser.parse(br);
			JSONObject jobj = (JSONObject) obj;
			JSONArray arr1 = (JSONArray) jobj.get("Doctors Details");
			Iterator it = arr1.iterator();
			System.out.println(" ______________________________________________________________________");
			System.out.println("|                                                                      | ");
			System.out.println("|Doctor Id \t Doctor Name \t    Specialization\tavailable Time |   ");
			System.out.println("|______________________________________________________________________|");

			while (it.hasNext()) {

				JSONObject jsonbj = (JSONObject) it.next();
				System.out.println();
				System.out.print("  " + jsonbj.get("Doctor Id").toString() + "\t\t");
				System.out.print(jsonbj.get("doctorName").toString() + "\t\t");
				System.out.print(jsonbj.get("sepcialization").toString() + "\t\t");
				System.out.print(jsonbj.get("available Timings").toString() + "\t\t");
				System.out.println();
				System.out.println(" ----------------------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

	@SuppressWarnings("unchecked")
	public boolean searchDetails(String Id, String temp, String temp2) {
		JSONParser parser = new JSONParser();
		try (BufferedReader br = new BufferedReader(new FileReader("clinical/clinique.json"))) {

			Object obj = parser.parse(br);
			JSONObject jsonbj = (JSONObject) obj;
			JSONArray array = (JSONArray) jsonbj.get(temp);
			if (array != null) {
				Iterator it = array.iterator();
				while (it.hasNext()) {
					JSONObject newobj = (JSONObject) it.next();
					if (newobj.get(temp2).equals(Id)) {
						return true;
					}
				}
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return false;
	}

	public JSONObject searchDetailsandget(String Id, String temp, String temp2, JSONObject jsonbj) {
		JSONArray array = (JSONArray) jsonbj.get(temp);
		if (array != null) {
			Iterator it = array.iterator();
			while (it.hasNext()) {
				JSONObject newobj = (JSONObject) it.next();
				if (newobj.get(temp2).equals(Id)) {
					return newobj;
				}
			}
		} else {
			return null;
		}
		return null;

	}

}
