package com.blbz.mediator;

import java.util.HashMap;
import java.util.Map;

public class ConcreteMediator implements Mediator {
	private final String Collegue_1 = "Collegue-1";
	private final String Collegue_2 = "Collegue-2";
	Map<String, Collegue> read = new HashMap<>();

	@Override
	public void notify(Collegue sender, String msg) {
		String senderName = sender.getName();
		if (Collegue_1.equals(senderName)) {
			reactOnc1(msg);
		} else if (Collegue_2.equals(senderName)) {
			reactOnc2(msg);
		}
	}

	@Override
	public void register(Collegue collegue) {
		this.read.put(collegue.getName(), collegue);
	}

	public void reactOnc1(String msg) {
		System.out.println("Mediator action..");
		read.get(Collegue_1).receiveFrmMtr(msg);
	}

	public void reactOnc2(String msg) {
		System.out.println("Mediator action..");
		read.get(Collegue_2).receiveFrmMtr(msg);
	}

}
