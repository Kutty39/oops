package com.blbz.Visitor;

public class VisitorMain {
	public static int calPrice(Item[] items) {
		Shoppingcart scr = new ShoppingCartImpl();
		int sum = 0;
		for (Item i : items) {
			sum = sum + i.accept(scr);
		}
		return sum;

	}

	public static void main(String[] args) {
		Item[] item = new Item[] { new Book(20, "1212"), new Book(30, "2345"), new Friut(40, 2, "apple"),
				new Friut(30, 3, "mango") };
		int total = calPrice(item);
		System.out.println("cost is" + total);
	}
}
