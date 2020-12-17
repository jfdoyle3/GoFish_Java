package com.careerdevs.main;

import com.careerdevs.cards.Deck;
import com.careerdevs.cards.GameDeck;
import com.careerdevs.cards.Hand;
import com.careerdevs.objects.Table;

public class TestsFlipping {

	public static void main(String[] args) {
		
		testCardFlip();
		

	}
	public static void testCardFlip() {
		
		Table table=new Table();
		table.getDeck().shuffle();
		for (int idx = 0; idx < 7; idx++) {
			table.getPlayer1().addCard(table.getDeck().draw(false));
		}
		System.out.println(table.getPlayer1().toString());
		table.getPlayer1().flipCard(3);
		System.out.println(table.getPlayer1().toString());
		table.getPlayer1().flipCard(2);
		System.out.println(table.getPlayer1().toString());
		table.getPlayer1().flipCard(1);
		System.out.println(table.getPlayer1().toString());
		table.getPlayer1().revealHand();
		System.out.println(table.getPlayer1().toString());
		table.getPlayer1().handFaceDown();
		System.out.println(table.getPlayer1().toString());
		System.out.println("\nend of Line");
	}
	
	public static void anotherTestFlipCard() {
		// test face down - false / face up - true
		Deck deck = new GameDeck();
		Hand hand = new Hand(null);
		hand.addCard(deck.draw(false));
		hand.addCard(deck.draw(false));
		hand.addCard(deck.draw(false));
		hand.addCard(deck.draw(false));
		System.out.println(hand.toString());
	}

}
