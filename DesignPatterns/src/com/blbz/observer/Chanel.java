package com.blbz.observer;

import java.util.ArrayList;
import java.util.List;

public class Chanel 
{
 List<Subscriber> su = new ArrayList<Subscriber>();
 private String title;
 public void subscribe(Subscriber sub)
 {
	 su.add(sub);
 }
 public void unsubscribe(Subscriber sub) {
	 su.remove(sub);
 }
 public void notifyUsers()
 {
	 for(Subscriber s: su)
	 {
		 s.update();
	 }
		 
		 
 }
 public void upload(String title) {
	 this.title = title;
	 notifyUsers();
 }
 
}
