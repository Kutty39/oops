package com.blbz.jsoninventory.UtilRepositry;

import java.util.Scanner;

public class Util {
	static Scanner sc = new Scanner(System.in);

	public static String stringInput() {
		try {
			return sc.nextLine();
		} catch (Exception e) {
			System.out.println("enter the correct value ");
		}
		return " ";

	}

	public static int integerInput() {
		int temp = 0;
		try {

			temp = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("enter the matching value ");
		}
		return temp;

	}

	public static double doublInput() {
		double temp = 0;
		try {
			temp = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("enter the matching value ");
		}
		return temp;

	}

	public static boolean boolenInput() {
		try {
			return sc.nextBoolean();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;

	}
}
