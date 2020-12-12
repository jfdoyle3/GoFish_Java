package com.careerdevs.cards;

import com.careerdevs.ui.Input;

public class SingleCard implements Deck {
	
	
	public void shuffle() {
		return;
	}
	
	public Card draw(boolean facing) {
		Input input=new Input();
		int cardValue= input.inputNumberText("card value: ");
		String cardSuit=input.inputStringText("card suit: ");
		return new Card(cardValue,cardSuit);
	}
	
	public boolean deckEmpty() {
		return false;
	}

}
