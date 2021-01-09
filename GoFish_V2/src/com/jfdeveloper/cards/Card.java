package com.jfdeveloper.cards;

import java.util.List;


public class Card {
	private int value;
	private String suit;
	private boolean faceDown = true;
	private final static String[] SUITS = { "♠", "♥", "♧", "♦" };

	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;

	}

	public String toString() {
		String output = "";
		switch (value) {
		case 1:
			output = "A";
			break;
		case 11:
			output = "J";
			break;
		case 12:
			output = "Q";
			break;
		case 13:
			output = "K";
			break;
		default:
			output = value == 10 ? Integer.toString(value) : "" + value;
		}
		return output + suit;
	}

	public int getValue() {
		return this.value;
	}

	public void flip() {
		faceDown = !faceDown;
	}

	public boolean isFaceDown() {
		return faceDown;
	}

}