package com.blbz.addressbook.model;

public class Person 
{
	 private String fName;
	 private String lName;
	 private long phoneNum;
	 
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + ", phoneNum=" + phoneNum + "]";
	}
	 
}
