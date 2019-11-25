package src.com.blbz.addressbook.model;

/*
 * purpose : created class for address details
 */
public class AddressBook 
{
private String city;
private String state;
private int zipCode;

public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getZipCode() {
	return zipCode;
}
public void setZipCode(int zipCode) {
	this.zipCode = zipCode;
}
@Override
public String toString() {
	return "AddressBook [city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
}
 
}
