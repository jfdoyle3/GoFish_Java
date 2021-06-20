package com.jfdeveloper.cards;

public interface Deck {

	void shuffle();

	Card draw(boolean facing);

	boolean deckEmpty();

}