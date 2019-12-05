package com.blbz.mediator;

public class Client 
{
       public static void main(String[] args) {
		Mediator mtr = new ConcreteMediator();
		Collegue c1 = new Collegue1("shivani", mtr);
		Collegue c2 = new Collegue2("kavya",mtr);
		mtr.register(c1);
		mtr.register(c2);
		c1.sendToMtr();
		c2.sendToMtr();
		
	}                      
}
