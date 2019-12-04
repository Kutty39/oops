package com.blbz.factory;

public class FactoryMain {
	public static void main(String[] args) {

		ProgrammFactory pf = new ProgrammFactory();
		ProgrammLanguage pl = pf.getInstance("jAVA");
		pl.perform();
	}
}
