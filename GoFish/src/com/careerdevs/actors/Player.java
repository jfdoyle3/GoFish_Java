package com.careerdevs.actors;

import java.util.ArrayList;
import java.util.List;

import com.careerdevs.cards.Card;
import com.careerdevs.cards.Deck;
import com.careerdevs.cards.Hand;
import com.careerdevs.ui.Console;
import com.careerdevs.ui.Input;

public class Player implements Actor {

	private Input input = new Input();
	private String playerName;
//	static int HIT = 1, STAND = 2, DOUBLE = 3, SPLIT = 4;
	
	

	public Player() {
		this.playerName = Input.inputStringText("What is your name? ");
	}

	public String getName() {
		return playerName;
	}



	@Override
	public int getAction(int handSize) {
		int option;
			option = input.inputNumberText("Which card? ");

		return option;
	}

}
