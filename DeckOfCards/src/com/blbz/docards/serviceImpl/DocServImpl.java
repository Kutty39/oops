package com.blbz.docards.serviceImpl;

import java.util.Random;

import com.blbz.docards.service.DocServ;

public class DocServImpl implements DocServ {
	public void deckOfCards(String[][] arr) {
		String[] faces = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Ace", "Jack", "King","Queen" };
		String[] suits = { "SPADES", "CLUBS", "DIAMONDS", "HEARTS" };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = suits[i] + " " + faces[j];
			}
		}
	}

	public void shuffle(String[][] arr) {
		Random randomNums = new Random();
		for (int i = 0; i < 52; i++)
		{
			int x1 = randomNums.nextInt(4);
			int x2 = randomNums.nextInt(13);
			int x3 = randomNums.nextInt(4);
			int x4 = randomNums.nextInt(13);
			String temp = arr[x1]	[x2];
			arr[x1][x2] = arr[x3][x4];
			arr[x3][x4] = temp;
				
			
		}
	}

	public String[][] displayCards() {
		String[][] arr = new String[4][13];
		deckOfCards(arr);
		shuffle(arr);		
		String[][] cards = new String[4][13];
		for(int i =0;i<cards.length;i++)
		{
			for(int j = 0;j < cards[i].length;j++)
			{
				cards[i][j] = arr[i][j];
			
			}
		}
		return cards;
		
	}
}
