package com.blbz.singleton;

public class StaticSingleton 
{
 private static StaticSingleton instanceOf;
 private StaticSingleton() {
	 System.out.println("StaticSingleton  created");
 }
 static {
	 try {
		 instanceOf = new StaticSingleton();
	
	 }catch(Exception e)
	 {
		 throw new RuntimeException("exception aoccured");
	 }
 }
 public static StaticSingleton getInstance() {
	
	
	return instanceOf;
	 
 }
}
