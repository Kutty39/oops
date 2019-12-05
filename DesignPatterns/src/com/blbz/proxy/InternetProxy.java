package com.blbz.proxy;

import java.util.ArrayList;
import java.util.List;

public class InternetProxy implements Internet
{
 private Internet in = new InternetImpl();
 private static List<String> server;
 static {
	 server = new ArrayList<String>();
	 server.add("google.com");
	 server.add("yahoo.com");
	 server.add("abcd.com");
	 server.add("new.com");
 }
	
	@Override
	public void connect(String str) throws Exception {
		if(server.contains(str.toLowerCase())) {
			throw new Exception("access denied to this network..");
		}
		in.connect(str);
	}

}
