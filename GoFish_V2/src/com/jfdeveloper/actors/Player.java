package com.jfdeveloper.actors;



import com.jfdeveloper.ui.Input;


public class Player implements Actor {

	private String playerName;

	
	

	public Player() {
		this.playerName = Input.inputStringText("What is your name? ");
	}

	public String getName() {
		return playerName;
	}



	@Override
	public int getAction(int handSize) {
		int option;
			option = Input.inputNumberText("Which card? ");

		return option;
	}

}
