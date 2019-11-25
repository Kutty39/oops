package src.com.blbz.addressbook.utilrepositry;
/*
 * purpose : to read all type of  inputs from user
 */
import java.util.Scanner;

public class Utility 
{
	static Scanner sc = new Scanner(System.in);

	public static String stringInput() {
		String temp = null ;
	
		
		try {
			temp = sc.nextLine();
            inputString(temp);
		} catch (Exception e) {
			System.out.println("enter the correct value ");
		}
		return temp;

	}

	public static boolean inputString(String string)
	{
		
		char[] ch = string.toCharArray();
		for(int i =0;i < ch.length;i++)
		{
			if(ch[i]>='0'&&ch[i]<='9') 
					 {
				return false;
			}
		}
		return true;
		
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
public static long longInput() {
	long temp = 0;
	try {
		temp = Long.parseLong(sc.nextLine());
	}catch(Exception e)
	{
		e.printStackTrace();
		System.out.println(e);
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
