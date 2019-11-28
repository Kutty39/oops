package com.blbz.docards.controller;

import com.blbz.docards.serviceImpl.DocServImpl;

public class DocMain 
{
public static void main(String[] args) {
	DocServImpl di = new DocServImpl();
	String[][] cards =di.displayCards();

	System.out.println("Player 1\tPlayer 2\tPlayer 3\tPlayer 4");
	System.out.println();
	int x = 0;
	int y = 0;
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 4; j++) {
			System.out.print(cards[x][y] + " \t");
			y++;
			if (y == 9) {
				y = 0;
				x++;
			}
		}
		System.out.println();
	}
}
	
}
