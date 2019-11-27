package com.blbz.clinique.controller;

import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.blbz.clinique.serviceImpl.CliniqueServImpl;
import com.blbz.clinique.utilRepositry.Utility;

public class CliniqueMain {
	static Utility utility = new Utility();
	static CliniqueServImpl csi = new CliniqueServImpl();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		int option = 0;
		do {

			System.out.println("\nchooce the choice..");
			System.out.println("1.for adding the details..");
			System.out.println("2.for booking appointment..");
			System.out.println("3.exit from this...");
			System.out.println("enter the option..");
			option = utility.integerInput();
			switch (option) {
			case 1:
				System.out.println("chooce one..");
				System.out.println("1.for adding the Doctor details.. ");
				System.out.println("2.for adding the patient details..");
				System.out.println("choose the which one details you want to add.. ");
				int choice = utility.integerInput();
				switch (choice) {
				case 1:
					System.out.println("enter the doctor details one by one..");
					csi.addDoctorDetails("Doctors Details");
					break;
				case 2:
					System.out.println("enter the patient details one by one..");
					csi.addPatientDetails("Patient Details");
					break;
				default:
					System.out.println("wrong choice..");
					break;
				}
				break;
			case 2:
				System.out.println("Book appointment for these doctors..");
				csi.showingDoctorDetails();
				System.out.println("enter the doctor id to book appointement..");
				String	id = "";
				id = utility.stringInput();
				do {
					if (!id.equals("")) {
						System.out.println("Enter valid doctor id");
					}
					
				
				} while (!csi.searchDetails(id, "Doctors Details", "Doctor Id"));
				JSONObject o = csi.searchDetailsandget(id, "Doctors Details", "Doctor Id");
				System.out.println("enter Patient id..");
				String pId ="";
				pId = utility.stringInput();
				do {
					if (!pId.equals("")) {
						System.out.println("Enter valid id");
					}
				
				} while (!csi.searchDetails(pId, "Patient Details", "Patient Id"));

				System.out.println("enter date to book.");
				String date = utility.stringInput();
				JSONObject o1=new JSONObject();
				JSONArray ary=new JSONArray();
				JSONArray bk=csi.getArray("Book Appointment");
				ary.add(pId);
				o1.put("Date", date);
				o1.put("availableTime", o.get("available Timings"))	;
				o1.put("Patient Id", ary)	;
				o1.put("Doctor Id", id)	;
				
				o = csi.searchDetailsandget(date, "Book Appointment", "Date");
				boolean t=false;
				if (o != null) {
					if (o.get("Doctor Id").equals(id)) {
						ary=(JSONArray) o.get("Patient Id");
						for(Object obj:ary) {
							if(obj.equals(pId)) {
								t=true;
								break;
							}
						}
						if(!t) {
							ary.add(pId);
						}
					} else {
						bk.add(o1);
					}
				}else {
					bk.add(o1);
				}
              try {
            	  FileWriter fw = new FileWriter("clinical/clinique.json");
            	  fw.write(o1.toJSONString());
            	  fw.close();
              }catch(Exception e) {
            	  e.printStackTrace();
              }
				break;
			case 3:
				System.out.println("succefully completed...");
				System.out.println("thank you..");
				break;
			default:
				System.out.println("wrong choice..,");
				break;
			}
		} while (option != 3);

	}
}
