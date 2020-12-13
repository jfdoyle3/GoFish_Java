package com.careerdevs.game;

import com.careerdevs.cards.Deck;
import com.careerdevs.cards.GameDeck;
import com.careerdevs.cards.Hand;
import com.careerdevs.objects.Table;
import com.careerdevs.ui.Console;

public class Game {

	private Table table = new Table();
	
	private boolean turn = true;

	public void playGame() {
		
		table.getDeck().shuffle();
		dealCards();
		table.getPlayer1().revealHand();
	
		
		//table.getPlayer1().groupCards();
		

		System.out.println("\nend of Line");
	}



	public void dealCards() {
		for (int idx = 0; idx < 7; idx++) {
			table.getPlayer1().getCard(table.getDeck().draw(true));
		}
	}

//	public int getChoice(Hand hand) {
//		return hand.getActor().getAction(hand.addUpCards());
//	}

//	public boolean choice(Hand hand, int action) {
//		switch (action) {
//		case 1:
//			Card card = table.getDeck().draw();
//			Console.hit(hand, card);
//			hand.getCard(card);
//			if (hand.addUpCards() > 21) {
//				hand.showHand();
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

	private void showTable( Hand playerHand) {
		Console.horzLine();
//		System.out.print(dealerHand.getName() + " -> ");
//		dealerHand.toString();
	//	System.out.println(" Hand total: " + dealerHand.addUpCards());
		Console.horzLine();
		System.out.print(playerHand.getName() + " -> ");
		playerHand.toString();
	//	System.out.println(" Hand total: " + playerHand.addUpCards());
	}
}
