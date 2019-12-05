package com.blbz.mediator;

public class Collegue2 extends Collegue {

	public Collegue2(String name, Mediator mtr) {
		super(name, mtr);

	}

	@Override
	public void sendToMtr() {
		 String msg = "Im not ok with this";
	      System.out.println(this.name+"collegue 2 is sending.."+msg);
	      mtr.notify(this,msg);
		
	}

	@Override
	public void receiveFrmMtr(String msg) {
		 System.out.println(this.name+"collegue 2 is receiving"+msg);
			}
		
	}


