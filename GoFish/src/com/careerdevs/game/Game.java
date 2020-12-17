package com.careerdevs.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.careerdevs.cards.Card;
import com.careerdevs.cards.Hand;
import com.careerdevs.objects.Table;
import com.careerdevs.ui.Console;
import com.careerdevs.ui.Input;

public class Game {

	private Table table = new Table();
	private Input input = new Input();
	private List<Card> emptyHand = new ArrayList<>();
	private HashMap<Integer,Integer> sortHand;

	public void playGame() {

		// Create Deck / Shuffle Deck
		table.getDeck().shuffle();

		// Deal Cards
		dealCards();

		// Display hand - ask for a card - finds card with same value and flip
		// them - display hand.
		displayTable();
		
		findCards(table.getPlayer2(), value);
		table.getPlayer1().addCard(table.getDeck().draw(true));
		
		// System.out.print("\033[H\033[2J");
		// System.out.flush();
		// System.out.println("\f");

		// System.out.println("\b");

		displayTable();
		// Pass cards into hand
		// Card passedCard=new Card(1,"1");
		// table.getPlayer1().addCard(passedCard);
		// System.out.println(table.getPlayer1().toString());

		System.out.println("\nend of Line");
	}

	private void displayTable() {
		System.out.println(table.getPlayer1().getName()+" Hand: " + table.getPlayer1().toString());
		System.out.println(table.getPlayer2().getName()+" Hand: " + table.getPlayer2().toString());
	}

	public void findCards(Hand player, int cardValue) {
		
		for (int idx = 0; idx < player.getCount(); idx++) {

			if (player.getCardValue(idx) == cardValue) {
			//	player.flipCard(idx);
			//	System.out.println("cards: "+idx);
			//	System.out.println(player.getName()+" hand has: "+player.toString());
				Card card=table.getPlayer1().getCard(idx);
				table.getPlayer1().addCard(card);
			//	player.discard(idx);			
			}
			
		}

	}

	public void dealCards() {
		for (int idx = 0; idx < 7; idx++) {
			table.getPlayer1().addCard(table.getDeck().draw(true));
			table.getPlayer2().addCard(table.getDeck().draw(false));
		}
	}



//	 public void groupCards() {
//	 sortHand = new HashMap<>();
//	 for (Card card : cards) {
//	 if (sortHand.containsKey(card.getValue()))
//	 sortHand.put(card.getValue(),
//	 sortHand.get(card.getValue()) + 1);
//	 else
//	 sortHand.put(card.getValue(), 1);
//	 }
//	 System.out.println(sortHand);
//	 // return sortHand;
//	 }
}

