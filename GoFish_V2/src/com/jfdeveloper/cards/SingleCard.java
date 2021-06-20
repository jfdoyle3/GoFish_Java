package com.jfdeveloper.cards;

import com.jfdeveloper.ui.Input;

public class SingleCard implements Deck {
	
	
	public void shuffle() {
		return;
	}
	
	public Card draw(boolean facing) {
		int cardValue= Input.inputNumberText("card value: ");
		String cardSuit=Input.inputStringText("card suit: ");
		return new Card(cardValue,cardSuit);
	}
	
	public boolean deckEmpty() {
		return false;
	}

}
