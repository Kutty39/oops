package com.blbz.observer;

public class Subscriber {
	private String name;
	private Chanel ch = new Chanel();

	public Subscriber(String name) {
		super();
		this.name = name;
	}
	public void update() {
		System.out.println("oye "+name+" video uploaded...");
	}
	public void subscribeChanel(Chanel ch1) {
		ch = ch1;
	}
}
