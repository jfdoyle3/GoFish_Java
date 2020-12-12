package com.careerdevs.game;

import com.careerdevs.actors.Actor;
import com.careerdevs.cards.Card;
import com.careerdevs.cards.Hand;
import com.careerdevs.objects.Table;
import com.careerdevs.ui.Console;
import com.careerdevs.ui.ErrorConsole;

public class Game {

	private Table table = new Table();
	private boolean choiceResult;
	private boolean turn = true;

	public void playGame() {
		table.getDeck().shuffle();

		int bet = table.getPlayers().getBet();
		Console.horzLine();
		Console.placedBet(table.getPlayers(), bet);
		Console.horzLine();
		dealCards();
		// TODO: Play a round till everyone is completed their turn.

		gameTurn(table.getPlayers());
		// playersTurn();
		// dealersTurn();

		// TODO: Decide winner / handle what happens to bet
		endRound(table.getDealers().addUpCards(), table.getPlayers().addUpCards(), bet);
		// TODO: handle what happens to bet
		// TODO: check players wallet to continue or end.
		System.out.println("\nend of Line");
	}

	private boolean gameTurn(Hand hand) {
		hand.showHand();
		int choice = hand.getActor().getAction(hand.addUpCards());
		choiceResult = choice(hand, choice);
		return choiceResult;

	}

	public void dealCards() {
		for (int idx = 0; idx < 4; idx++) {
			if (idx % 2 == 0) {
				table.getPlayers().getCard(table.getDeck().draw());
			} else {
				table.getDealers().getCard(table.getDeck().draw());
			}
		}
	}

	public int getChoice(Hand hand) {
		return hand.getActor().getAction(hand.addUpCards());
	}

	public boolean choice(Hand hand, int action) {
		switch (action) {
		case 1:
			Card card = table.getDeck().draw();
			Console.hit(hand, card);
			hand.getCard(card);
			if (hand.addUpCards() > 21) {
				hand.showHand();
				Console.bust(hand.getName(), hand.addUpCards());
				return true;
			}
			return false;
		case 2:
			Console.stand(hand.getName(), hand.addUpCards());
			return true;
		default:
			ErrorConsole.errorChoice();
			return true;
		}
	}

	public void endRound(int dealerHand, int playerHand, int chips) {

		if (dealerHand > playerHand) {
			// cash - bet;
			Console.win("Dealer");
		}
		if (dealerHand < playerHand) {
			Console.win("Player");
			// System.out.printf("\nPlayers wins--> %d ", Player.wins(chips));
		}
		if (dealerHand == playerHand) {
			Console.push();

		}
	}

	private void showTable(Hand dealerHand, Hand playerHand) {
		Console.horzLine();
		System.out.print(dealerHand.getName() + " -> ");
		dealerHand.showHand();
		System.out.println(" Hand total: " + dealerHand.addUpCards());
		Console.horzLine();
		System.out.print(playerHand.getName() + " -> ");
		playerHand.showHand();
		System.out.println(" Hand total: " + playerHand.addUpCards());
	}
}
