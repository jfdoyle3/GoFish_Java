package com.jfdeveloper.game;

import java.util.HashMap;
import java.util.Map.Entry;

import com.jfdeveloper.cards.Hand;
import com.jfdeveloper.ui.Input;

public class Game {

	private Table table = new Table();
	private Input input = new Input();
	private HashMap<Integer, Integer> sortHand;
	private int playerOneScore = 0;
	private int playerTwoScore = 0;
	private HashMap<String, Integer> scoreBoard;

	public void playGame() {
		scoreBoard = new HashMap<String, Integer>();
		table.getDeck().shuffle();
		// Deal Cards
		dealCards();
		do {
			do {
			} while (!actorTurn(table.getPlayer1()));

			System.out.println("<---------------------------------------->");
			getPointsPlayerOne();
			System.out.println("go fish player");
			pause(1000);
			table.getPlayer1().addCard(table.getDeck().draw(true));
			table.getPlayer1().revealHand();
			System.out
					.println("<--------------- End Player 1 --------------->");

			do {
			} while (!actorTurn(table.getPlayer2()));
			System.out.println("<---------------------------------------->");
			getPointsPlayerTwo();
			System.out.println("go fish computer");
			pause(1000);
			table.getPlayer2().addCard(table.getDeck().draw(false));
			table.getPlayer2().handFaceDown();
			System.out
					.println("<--------------- End Player 2 --------------->");

		} while (table.getPlayer2().getCount() > 0
				|| table.getPlayer2().getCount() > 0);

		if (playerOneScore > playerTwoScore) {
			System.out.println(table.getPlayer1().getName() + " Wins.");
		} else {
			System.out.println(table.getPlayer2().getName() + " Wins.");
		}

		System.out.println("\nend of Line");
	}

	private void getPointsPlayerOne() {
		HashMap<Integer, Integer> hashHand = table.getPlayer1().groupCards();
		int booksFound = findBooks(hashHand, playerOneScore);
		playerOneScore = +booksFound;

	}
	private void getPointsPlayerTwo() {
		HashMap<Integer, Integer> hashHand = table.getPlayer2().groupCards();
		int booksFound = findBooks(hashHand, playerTwoScore);
		playerTwoScore = +booksFound;

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
		for (int idx = 0; idx < 4; idx++) {
			table.getPlayer1().addCard(table.getDeck().draw(true));
			table.getPlayer2().addCard(table.getDeck().draw(false));
		}
	}

	public int findBooks(HashMap<Integer, Integer> hm, int score) {
		for (Entry<Integer, Integer> entry : hm.entrySet()) {
			if (entry.getValue() % 2 == 0) {
				// hm.remove(entry.getKey());
				score++;
				removeBooks(table.getPlayer1(), entry.getKey());
				// System.out.println("card: " + entry.getKey());
				// return entry.getKey();
			}
		}
		System.out.println("Score: " + score);
		return score;
	}

	public void removeBooks(Hand hand, int cardValue) {
		for (int idx = 0; idx < hand.getCount(); idx++) {
			if (hand.getCardValue(idx) == cardValue) {
				hand.discard(idx);
				idx--;
			}
		}
		playerOneScore++;
		System.out.println("P Score: " + playerOneScore);
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
	public void pause(int time) {
		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(time);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
