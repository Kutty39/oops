package com.blbz.clinique.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
				JSONParser parser = new JSONParser();
				try (BufferedReader br = new BufferedReader(new FileReader("clinical/clinique.json"));) {
					Object obj1 = parser.parse(br);
					JSONObject base = (JSONObject) obj1;
					System.out.println("Book appointment for these doctors..");
					csi.showingDoctorDetails();
					System.out.println("enter the doctor id to book appointement..");
					String id = "";
					do {
						if (!id.equals("")) {
							System.out.println("Enter valid doctor id");
						}
						id = utility.stringInput();
					} while (!csi.searchDetails(id, "Doctors Details", "Doctor Id"));
					JSONObject o = csi.searchDetailsandget(id, "Doctors Details", "Doctor Id", base);
					System.out.println("enter Patient id..");
					String pId = "";
					do {
						if (!pId.equals("")) {
							System.out.println("Enter valid id");
						}
						pId = utility.stringInput();
					} while (!csi.searchDetails(pId, "Patient Details", "Patient Id"));
					System.out.println("enter the date below format to book appointment.");
					System.out.println("*******eg.23/08/2019 **********");
					String date = utility.stringInput();
					JSONObject o1 = new JSONObject();
					JSONArray ary = new JSONArray();
					JSONArray bk = (JSONArray)base.get("Book Appointment");
					
					ary.add(pId);
					o1.put("Date", date);
					o1.put("availableTime", o.get("available Timings"));
					o1.put("Patient Id", ary);
					o1.put("Doctor Id", id);

					o = csi.searchDetailsandget(date, "Book Appointment", "Date", base);
					boolean t = false;
					if (o != null) {
						if (o.get("Doctor Id").equals(id)) {
							ary = (JSONArray) o.get("Patient Id");
							if (ary.size() < 5) {
								for (Object obj : ary) {
									if (obj.equals(pId)) {
										t = true;
										break;
									}
								}
								if (!t) {
									ary.add(pId);
							
								}
							System.out.println("successfully you booked appointment on this day "+date);
							} else {
								System.out.println("all apointments booked on the "+date+" for this doctor");
								System.out.println("please enter other date or choose one more doctor..");
							}
						} else {
							bk.add(o1);
						}
					} else {
						bk.add(o1);
					}
                    
					FileWriter fw = new FileWriter("clinical/clinique.json");
					fw.write(base.toJSONString());
					fw.close();
					br.close();

				} catch (Exception e) {
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
