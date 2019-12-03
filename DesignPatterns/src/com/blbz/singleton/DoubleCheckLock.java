package com.blbz.singleton;

public class DoubleCheckLock 
{
	private static DoubleCheckLock instance;
	private DoubleCheckLock() {
		System.out.println("created");
	}
	public static synchronized DoubleCheckLock getInstance() {
		if(instance == null)
		{
		synchronized(DoubleCheckLock.class)
		{
		if(instance == null) {
			instance = new DoubleCheckLock();
		}
		}
		}
		return instance;
	}
		
}

