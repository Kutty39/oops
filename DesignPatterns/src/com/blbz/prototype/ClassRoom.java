package com.blbz.prototype;

import java.util.ArrayList;

public class ClassRoom implements Cloneable 
{
private String className;
ArrayList<Student> al = new ArrayList<>();

public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
public ArrayList<Student> getAl() {
	return al;
}
public void setAl(ArrayList<Student> al) {
	this.al = al;
}
public void loadClass()
{
	for(int i = 0;i < 10;i++)
	{
	Student s = new Student();
	s.setStId(i);
	s.setStName("Student"+i);
	getAl().add(s);
	
	
	}
}


@Override
public String toString() {
	return "ClassRoom [className=" + className + ", al=" + al + "]";
}
@Override
protected ClassRoom clone() throws CloneNotSupportedException {
	
	ClassRoom clsr = new ClassRoom();
	for(Student ss:this.getAl())
	{
		clsr.getAl().add(ss);
	}
	return clsr;
}


}
