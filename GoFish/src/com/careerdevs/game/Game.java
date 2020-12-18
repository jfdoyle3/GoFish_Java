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
	private HashMap<Integer, Integer> sortHand;
	private boolean emptyHand;
	private boolean inHand = false;

	public void playGame() {

		// Create Deck / Shuffle Deck
		table.getDeck().shuffle();

		// Deal Cards
		dealCards();

		// Display hand - ask for a card - finds card with same value and flip
		// them - display hand.
		// displayTable();

		// Human player choose card value

		// int pickCard = input.inputNumberText("Which card? ");
		// findCards(table.getPlayer2(), table.getPlayer1(), pickCard);

		// Draw on Go Fish
		// table.getPlayer1().addCard(table.getDeck().draw(true));

		// Computer
		// System.out.println("Computer picks: ");

		// int computerPick = 3;
		// findCards(table.getPlayer1(), table.getPlayer2(), computerPick);

		// if (table.getPlayer1().getCount()==0 ||
		// table.getPlayer2().getCount()==0)
		// emptyHand=true;

		do {
		} while (!actorTurn(table.getPlayer1()));

		// displayTable();

		// Pass cards into hand
		// Card passedCard=new Card(1,"1");
		// table.getPlayer1().addCard(passedCard);
		// System.out.println(table.getPlayer1().toString());

		System.out.println("\nend of Line");
	}

	private void displayTable() {
		System.out.println(table.getPlayer1().getName() + " Hand: "
				+ table.getPlayer1().toString());
		System.out.println(table.getPlayer2().getName() + " Hand: "
				+ table.getPlayer2().toString());
	}

	private boolean actorTurn(Hand hand) {
		displayTable();
		return performAction(hand, getAction(hand));
	}

	private int getAction(Hand hand) {
		return hand.getActor().getAction();
		// 1 or 2
		// return ;
	}

	private boolean performAction(Hand hand, int action) {
		switch (action) {
			case 1 :
				int pickCard = input.inputNumberText("Which card? ");
				findCards(table.getPlayer2(), table.getPlayer1(), pickCard);
				return false;
			case 2 :
				Card card = table.getDeck().draw(true);
				System.out
						.println(hand.getName() + " Go Fish - picked: " + card);
				hand.addCard(card);
				return true;
			default :
				System.out.println("error! default case Go Fish");
				return true;
		}
	}
	public void findCards(Hand player, Hand player2, int cardValue) {

		for (int idx = 0; idx < player.getCount(); idx++) {
			if (player.getCardValue(idx) == cardValue) {
				Card card = player.discard(idx);
				System.out.println("discarded: " + idx);
				player2.addCard(card);
				System.out.println("added: " + idx);

			}
		}

	}

	public void dealCards() {
		for (int idx = 0; idx < 7; idx++) {
			table.getPlayer1().addCard(table.getDeck().draw(true));
			table.getPlayer2().addCard(table.getDeck().draw(true));
		}
	}

	// public void groupCards() {
	// sortHand = new HashMap<>();
	// for (Card card : cards) {
	// if (sortHand.containsKey(card.getValue()))
	// sortHand.put(card.getValue(),
	// sortHand.get(card.getValue()) + 1);
	// else
	// sortHand.put(card.getValue(), 1);
	// }
	// System.out.println(sortHand);
	// // return sortHand;
	// }
}
