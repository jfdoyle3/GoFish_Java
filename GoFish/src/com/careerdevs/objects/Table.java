package com.careerdevs.objects;

import com.careerdevs.actors.Dealer;
import com.careerdevs.actors.Player;
import com.careerdevs.cards.Deck;
import com.careerdevs.cards.GameDeck;
import com.careerdevs.cards.Hand;

public class Table {

	private Hand players = new Hand(new Player());
	private Hand dealers = new Hand(new Dealer());
	private Deck deck = new GameDeck();

	public Deck getDeck() {
		return deck;
	}

	public Hand getDealers() {
		return dealers;
	}

	public Hand getPlayers() {
		return players;
	}

}
