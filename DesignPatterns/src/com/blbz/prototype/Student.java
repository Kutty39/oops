package com.blbz.prototype;

public class Student 
{
private int stId;
private String stName;

public int getStId() {
	return stId;
}
public void setStId(int stId) {
	this.stId = stId;
}
public String getStName() {
	return stName;
}
public void setStName(String stName) {
	this.stName = stName;
}
@Override
public String toString() {
	return "Student [stId=" + stId + ", stName=" + stName + "]";
}

}
