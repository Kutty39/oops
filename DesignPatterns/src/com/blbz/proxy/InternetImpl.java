package com.blbz.proxy;

public class InternetImpl implements Internet
{

	@Override
	public void connect(String str) throws Exception {
	System.out.println("connecting to this network.."+str);
		
	}

}
