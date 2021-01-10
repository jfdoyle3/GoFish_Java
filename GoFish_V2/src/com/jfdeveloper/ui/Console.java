package com.jfdeveloper.ui;

import java.util.List;

import com.jfdeveloper.cards.Card;

public class Console {

	public static void displayCard(Card card) {
		System.out.print(card.toString() + " ");
	}

	public static void horzLine() {
		System.out.println("-----------------------------------------------------------------------------");
	}

}
