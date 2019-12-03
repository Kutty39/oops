package com.blbz.singleton;

public class ThreadSingle 
{
private static ThreadSingle instance;
private ThreadSingle() {
	System.out.println("created");
}
public static synchronized ThreadSingle getInstance() {
	if(instance == null) {
		instance = new ThreadSingle();
	}
	return instance;
}
}
