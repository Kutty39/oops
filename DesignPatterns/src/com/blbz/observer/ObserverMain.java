package com.blbz.observer;

public class ObserverMain {
	public static void main(String[] args) {

		Chanel chl = new Chanel();
		Subscriber sc1 = new Subscriber("user1");
		Subscriber sc2 = new Subscriber("user2");
		Subscriber sc3 = new Subscriber("user3");
		Subscriber sc4 = new Subscriber("user4");
		chl.subscribe(sc1);
		chl.subscribe(sc2);
		chl.subscribe(sc3);
		chl.subscribe(sc4);
		sc1.subscribeChanel(chl);
		sc2.subscribeChanel(chl);
		sc3.subscribeChanel(chl);
		sc4.subscribeChanel(chl);
	chl.upload("uploaded");
		
	}

}
