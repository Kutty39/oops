package com.blbz.singleton;

public class LazySingleton 
{
private  static LazySingleton instance;
private LazySingleton() {
	System.out.println("created");
}
public static LazySingleton getInstance() {
	if(instance == null) {
		instance = new LazySingleton();
	}
	return instance;
	
}
}
