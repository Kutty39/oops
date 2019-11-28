package com.blbz.clinique.controller;

import java.io.FileWriter;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main 
{
	public static void deckOfCards(String[][] arr) {
		String[] faces = { "two", "thre", "four", "five", "six", "seven", "eite", "nine", "ten", "Ace", "Jack", "King",
				"Queen" };
        String[] suits = {"SPADES","CLUBS","DIAMONDS","HEARTS"};
        for(int i = 0;i < arr.length;i++)
        {
        	for(int j = 0;j < arr[i].length;j++)
        	{
        		arr[i][j] = suits[i]+" "+faces[j];
        	}
        }
	}
	
	public static void shuffle(String[][] arr)
	{
		Random randomNums = new Random();
	//	for(int i =0;i<)
	}
}
