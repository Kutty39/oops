package com.blbz.adapter;

import com.blbz.Helper.Samsung;

public class MobileAdapter implements Iphone
{
	Samsung s = new Samsung();

	public void charger(String str) {
		s.charging(str);
	}

}
