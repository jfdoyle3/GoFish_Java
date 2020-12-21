package com.careerdevs.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.careerdevs.cards.Card;
import com.careerdevs.cards.Hand;
import com.careerdevs.ui.Console;
import com.careerdevs.ui.Input;

public class Game {

	private Table table = new Table();
	private Input input = new Input();
	private HashMap<Integer, Integer> sortHand;
	private boolean emptyHand;
	private boolean inHand = false;
	private int playerScore=0;
	private HashMap<String, Integer> scoreBoard;

	public void playGame() {
		scoreBoard=new HashMap<String,Integer>();
		// Create Deck / Shuffle Deck
		table.getDeck().shuffle();

		// Deal Cards
		dealCards();

		
		do {
			do {
			} while (!actorTurn(table.getPlayer1()));
			System.out.println("go fish player");
			table.getPlayer1().addCard(table.getDeck().draw(true));
			HashMap<Integer, Integer> hashHand = table.getPlayer1()
					.groupCards();
			int booksFound=findBooks(hashHand, playerScore);
			playerScore=+booksFound;
			System.out.println("gl: "+playerScore);
			//removeBooks(table.getPlayer1(), cardValue);
//			 do {
//			 } while (!actorTurn(table.getPlayer2()));
//			 System.out.println("go fish computer");
//			 table.getPlayer2().addCard(table.getDeck().draw(true));

		} while (table.getPlayer2().getCount() > 0
				|| table.getPlayer2().getCount() > 0);
	

			
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
		return hand.getActor().getAction(hand.getCount());

	}

	private boolean performAction(Hand hand, int action) {

		int pickCard = action;
		// System.out.println("Computer chooses: "+pickCard);
		findCards(table.getPlayer2(), table.getPlayer1(), pickCard);
		displayTable();
		return true;
		//
		// Card card = table.getDeck().draw(true);
		// System.out.println(hand.getName() + " Go Fish - picked: " + card);
		// hand.addCard(card);
		// return true;
		//
		// System.out.println("error! default case Go Fish");
		// return true;

	}
	public void findCards(Hand player, Hand player2, int cardValue) {
		for (int idx = 0; idx < player.getCount(); idx++) {
			if (player.getCardValue(idx) == cardValue) {
				player2.addCard(player.discard(idx));
				idx--;
			}
		}

	}

	public void dealCards() {
		for (int idx = 0; idx < 7; idx++) {
			table.getPlayer1().addCard(table.getDeck().draw(true));
			table.getPlayer2().addCard(table.getDeck().draw(false));
		}
	}

	public int findBooks(HashMap<Integer, Integer> hm, int score) {
		for (Entry<Integer, Integer> entry : hm.entrySet()) {
			if (entry.getValue()%2==0) {
				// hm.remove(entry.getKey());
				score++;
				System.out.println("card: " + entry.getKey());
			//	return entry.getKey();
			}
		}
		System.out.println("Score: "+score);
		return score;
	}

	public void removeBooks(Hand hand, int cardValue) {
		for (int idx = 0; idx < hand.getCount(); idx++) {
			if (hand.getCardValue(idx) == cardValue) {
				hand.discard(idx);
				idx--;
			}
		}
		playerScore++;
		System.out.println("P Score: "+playerScore);
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
