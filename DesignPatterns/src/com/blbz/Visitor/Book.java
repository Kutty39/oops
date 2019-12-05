package com.blbz.Visitor;

public class Book implements Item
{
private int price;
private String isbkNum;

	
	public Book(int price, String isbkNum) {
	super();
	this.price = price;
	this.isbkNum = isbkNum;
}


	public int getPrice() {
	return price;
}


public void setPrice(int price) {
	this.price = price;
}


public String getIsbkNum() {
	return isbkNum;
}


public void setIsbkNum(String isbkNum) {
	this.isbkNum = isbkNum;
}


	@Override
	public int accept(Shoppingcart visitor) {
		
		return visitor.visit(this);
	}

}
