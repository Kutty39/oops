package com.blbz.singleton;

public class BillSingle 
{
private BillSingle() {
	System.out.println("bill");
}
public static class BillSingleInner{
	private static BillSingle instance = new BillSingle();
}
public static BillSingle getInstance() {
	
	return BillSingleInner.instance;
	
}
}
