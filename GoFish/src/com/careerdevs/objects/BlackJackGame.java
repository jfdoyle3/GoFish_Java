package com.careerdevs.objects;

import java.util.List;

import com.careerdevs.actors.Actor;
import com.careerdevs.cards.Card;
import com.careerdevs.cards.Deck;
import com.careerdevs.cards.Hand;
import com.careerdevs.ui.Console;
import com.careerdevs.ui.ErrorConsole;
import com.careerdevs.ui.Input;

public class BlackJackGame {

	Table table = new Table();

//	public void round(String name, Deck deck, List<Card> playerHand) {
//		boolean play = true;
//		table.getDeck().shuffle();
//		dealCards();
//		table.getDealersHand().showHand();
//		table.getPlayersHand().showHand();

//	}

	public static void endRound(int dealerHand, int playerHand, int chips) {

		if (dealerHand > playerHand) {
			Console.win("Dealer");
		}
		if (dealerHand < playerHand) {
			Console.win("Player");
			// System.out.printf("\nPlayers wins--> %d ", Player.wins(chips));
		}
		if (dealerHand == playerHand) {
			Console.push();

		}

//		public static int wins(int chipsBet) {
//			int chipsWon = chipsBet * 2;
//			return chipsWon;
//
//		}
	}

	public static int placeBet(int chips) {
		boolean betPlaced = false;
		Console.bet(chips);
		do {
			int betAmount = Input.inputNumberText("Bet?");
			if (betAmount > chips) {
				betPlaced = false;
				ErrorConsole.errorBet(chips);
			} else {
				betPlaced = true;
				chips -= betAmount;
			}
		} while (!betPlaced);
		return setChips(chips);
	}

	private static int setChips(int chips) {
		return chips;
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

//	public boolean choice(Hand hand, int action) {
//		switch (action) {
//		case 1:
//			Card card = table.getDeck().draw();
//			Console.hit(hand, card);
//			hand.getCard(card);
//			if (hand.addUpCards() > 21) {
//				Console.bust(hand.getName(), hand.addUpCards());
//				return true;
//			}
//			return false;
//		case 2:
//			Console.stand(hand.getName(), hand.addUpCards());
//			return true;
//		default:
//			ErrorConsole.errorChoice();
//			return true;
//		}

//	}
}
