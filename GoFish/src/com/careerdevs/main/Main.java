package com.careerdevs.main;

import com.careerdevs.cards.Deck;
import com.careerdevs.cards.GameDeck;
import com.careerdevs.cards.Hand;
import com.careerdevs.game.Game;

public class Main {

	public static void main(String[] args) {

//		Game game = new Game();
//		game.playGame();
		// BlackJack testGame=new BlackJack();
		// testGame.play();

		// test face down - false / face up - true
		Deck deck = new GameDeck();
		Hand hand = new Hand(null);
		hand.getCard(deck.draw(false));
		hand.getCard(deck.draw(false));
		hand.getCard(deck.draw(false));
		hand.getCard(deck.draw(false));
		System.out.println(hand.toString());

	}

}
