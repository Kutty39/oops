package com.blbz.mediator;

public abstract class Collegue 
{
protected static String name;
protected Mediator mtr;

public Collegue(String name, Mediator mtr) {
	this.name = name;
	this.mtr = mtr;
}

public abstract void sendToMtr();
public abstract void receiveFrmMtr(String msg);

public String getName() {
	return this.name;
}



}
