package com.blbz.prototype;

public class PrototypeMain 
{
public static void main(String[] args) throws CloneNotSupportedException {
	ClassRoom  cr = new ClassRoom();
	cr.setClassName("Maths");
	cr.loadClass();
	
	
	ClassRoom cr1 =  cr.clone();
	cr.getAl().remove(1);
	System.out.println(cr);
	cr1.setClassName("science");
	System.out.println(cr1);


}
}
