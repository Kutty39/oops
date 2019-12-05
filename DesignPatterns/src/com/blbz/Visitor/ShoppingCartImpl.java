package com.blbz.Visitor;

public class ShoppingCartImpl implements Shoppingcart
{

	@Override
	public int visit(Book book) {
		int cost = 0;
		if(book.getPrice()>50)
		{
			cost = book.getPrice()-5;
		}else 
			cost = book.getPrice();
		System.out.println("booknumber"+book.getIsbkNum()+"cost is "+cost);
		return cost;
	}

	@Override
	public int visit(Friut friut) {
		int cal = friut.getWeight()*friut.getPricePerKg();
		System.out.println("fruit name is"+friut.getName()+"price is "+cal);
		
		return cal;
	}

}
