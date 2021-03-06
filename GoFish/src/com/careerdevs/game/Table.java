package com.careerdevs.game;

import com.careerdevs.actors.Dealer;
import com.careerdevs.actors.Player;
import com.careerdevs.cards.Deck;
import com.careerdevs.cards.GameDeck;
import com.careerdevs.cards.Hand;

public class Table {
	
	private Hand player1 = new Hand(new Player());
	private Hand player2 = new Hand(new Dealer());
	private Deck deck = new GameDeck();


	public Deck getDeck() {
		return deck;
	}

	 public Hand getPlayer2() {
	 return player2;
	 }

	public Hand getPlayer1() {
		return player1;
	}


}
