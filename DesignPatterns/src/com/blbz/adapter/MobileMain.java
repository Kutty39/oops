package com.blbz.adapter;

import com.blbz.Helper.Samsung;

public class MobileMain {
	public static void main(String[] args) {
     
		//Samsung s = new Samsung();
		Iphone ch = new MobileAdapter();
		MobileCharge mc = new MobileCharge();
		mc.setIp(ch);
		mc.getCharge("i will get charge");
	}
}
