package com.blbz.factory;

public class ProgrammFactory 
{
public ProgrammLanguage getInstance(String str) {
	if(str.equalsIgnoreCase("java"))
	{
		return new Java();
	}
	else if(str.equalsIgnoreCase("Php"))
	{
		return new Php();
	}else
	
	return new Python();
	
}
}
