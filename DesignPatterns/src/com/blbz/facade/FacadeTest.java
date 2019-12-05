package com.blbz.facade;

public class FacadeTest {
	public static void main(String[] args) {
      FacadeImpl fi = new FacadeImpl();
      System.out.println(fi.buildIphone());
      System.out.println(fi.buildAppo());
      System.out.println(fi.buildRealme());
	}
}
