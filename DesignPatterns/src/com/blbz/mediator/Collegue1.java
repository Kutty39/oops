package com.blbz.mediator;

public class Collegue1 extends Collegue {

	public Collegue1(String name, Mediator mtr) {
		super(name, mtr);

	}

	@Override
	public void sendToMtr() {
      String msg = "Im ok.";
      System.out.println(this.name+"collegue 1 is sending.."+msg);
      mtr.notify(this,msg);
      
	}

	@Override
	public void receiveFrmMtr(String msg) {
    System.out.println(this.name+"collegue 1 is receiving"+msg);
	}

}
