package com.blbz.singleton;

import java.lang.reflect.Constructor;

public class TestEager 
{
public static void main(String[] args) 
{
	//StaticSingleton obj = StaticSingleton.getInstance();
	//LazySingleton obj= LazySingleton.getInstance();
	//ThreadSingle obj = ThreadSingle.getInstance();
	//DoubleCheckLock obj = DoubleCheckLock.getInstance();
	//BillSingle obj = BillSingle.getInstance();
		/*
		 * EagerSingleton inst1 = EagerSingleton.getInstance(); EagerSingleton inst2 =
		 * null; try {
		 * 
		 * Constructor[] cstrs = EagerSingleton.class.getDeclaredConstructors();
		 * for(Constructor cstr: cstrs) { System.out.println(cstr.isAccessible());
		 * cstr.setAccessible(true); inst2 = (EagerSingleton)cstr.newInstance(); break;
		 * } }catch(Exception e) { e.printStackTrace(); }
		 * System.out.println(inst1.hashCode()); System.out.println(inst2.hashCode());
		 */
		/*
		 * EnumSingleton obj = EnumSingleton.instance; obj.i = 5; obj.show();
		 */
	
}
}
