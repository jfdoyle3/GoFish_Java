package com.careerdevs.actors;

import java.util.ArrayList;
import java.util.List;

import com.careerdevs.cards.Card;
import com.careerdevs.cards.Deck;
import com.careerdevs.cards.Hand;
import com.careerdevs.ui.Console;
import com.careerdevs.ui.ErrorConsole;
import com.careerdevs.ui.Input;

public class Player implements Actor {

	private Input input = new Input();
	private String playerName;
	static int HIT = 1, STAND = 2, DOUBLE = 3, SPLIT = 4;
	private int cash;
	private int bet;

	public Player() {
		this.playerName = Input.inputStringText("What is your name? ");
		this.cash = 2000;

	}

	public String getName() {
		return playerName;
	}

	@Override
	public int setBet() {
		boolean betPlaced = false;
		Console.bet(cash);
		do {
			bet = Input.inputNumber();
			if (bet > cash && bet < 0) {
				betPlaced = false;
				ErrorConsole.errorBet(cash);
			} else {
				betPlaced = true;
			}
		} while (!betPlaced);

		return bet;
	}

	@Override
	public int getAction(int score) {
		int option;
		do {
			option = Input.inputNumberText("Choices: 1-Hit or 2-Stand? ");

		} while (option < 1 || option > 2);

		return option;
	}

	public void addCash(int amount) {
		cash += amount;
	}

	public void addCash(int amount, String condition) {
		switch (condition) {
		case "win":
			cash += amount;
			break;
		case "lose":
			cash -= amount;
			break;
		}
	}
}
