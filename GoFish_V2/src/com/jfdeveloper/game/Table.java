package com.jfdeveloper.game;

import com.jfdeveloper.actors.Dealer;
import com.jfdeveloper.actors.Player;
import com.jfdeveloper.cards.Deck;
import com.jfdeveloper.cards.GameDeck;
import com.jfdeveloper.cards.Hand;

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
