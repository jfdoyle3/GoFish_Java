package com.careerdevs.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.careerdevs.cards.Card;
import com.careerdevs.objects.Table;
import com.careerdevs.ui.Console;
import com.careerdevs.ui.Input;


public class Game {

	private Table table = new Table();
	private Input input= new Input();
	private List<Card> discard=new ArrayList<>();

	public void playGame() {
		
		table.getDeck().shuffle();
		dealCards();
		
		System.out.println("Hand: "+table.getPlayer1().toString());
		int pickCard=Input.inputNumberText("Ask for a card from 0-6? ");
		for (int idx=0; idx<table.getPlayer1().getCount(); idx++) {
		Card discardedCard=table.getPlayer1().askForCards(pickCard);
		discard.add(discardedCard);
		System.out.println("Hand: "+table.getPlayer1().toString());
		}
//		table.getPlayer1().groupCards();
//		int pickCard=Input.inputNumberText("Pick a card flip from 0-6? ");
//		table.getPlayer1().flipCard(pickCard);
//		System.out.println("Hand: card flipped: "+table.getPlayer1().toString());
//		table.getPlayer1().groupCards();
//		Card card=table.getPlayer1().discard(1);
//		discard.add(card);
//		System.out.println("Hand: discarded: "+table.getPlayer1().toString());
//		table.getPlayer1().groupCards();
//		System.out.println("card:");
//		for (Card cards : discard)
//			System.out.print(cards+" ");
		
		
		//Card passedCard=new Card(1,"1");
		
		//table.getPlayer1().addCard(passedCard);
		
	//	System.out.println(table.getPlayer1().toString());
		
		
		
		
		
		System.out.println("\nend of Line");
	}




	public void dealCards() {
		for (int idx = 0; idx < 7; idx++) {
			table.getPlayer1().addCard(table.getDeck().draw(true));
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

}
