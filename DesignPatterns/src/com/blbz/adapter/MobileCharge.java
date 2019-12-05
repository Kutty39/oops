package com.blbz.adapter;

public class MobileCharge {
	private Iphone ip;

	public Iphone getIp() {
		return ip;
	}

	public void setIp(Iphone ip) {
		this.ip = ip;
	}

	public void getCharge(String str) {
      ip.charger(str);
	}
}
