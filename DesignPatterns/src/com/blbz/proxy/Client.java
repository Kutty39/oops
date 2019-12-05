package com.blbz.proxy;

public class Client {
	public static void main(String[] args) {

		Internet internet = new InternetProxy();
		try {
          internet.connect("nothing.com");
          internet.connect("google.com");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
