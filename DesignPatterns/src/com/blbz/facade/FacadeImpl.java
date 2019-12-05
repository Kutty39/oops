package com.blbz.facade;



public class FacadeImpl 
{
private Iphne ip;
private Appo ap;
private RealMe rm;

public FacadeImpl() {
	ip = new Iphne();
	ap = new Appo();
	rm = new RealMe();
	
}
public String buildIphone() {
	return ip.making();
	
}
public String buildAppo() {
	return ap.making();
	
}
public String buildRealme() {
	return rm.making();
	
}
}
