package com.careerdevs.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.careerdevs.actors.Actor;

public class Hand {

	
	private List<Card> cards = new ArrayList<>();
	private HashMap<Integer, Integer> sortHand;
	private Actor actor;

	public Hand(Actor actor) {
		this.actor = actor;
	}

	public String getName() {
		return actor.getName();
	}

	public Actor getActor() {
		return actor;
	}

	@Override
	public String toString() {
		String output = "";
		for (var card : cards) {
			output += card.isFaceDown() ? "## " : card + " ";
		}
		return output.trim();
	}
	// <*>
	public void addCard(Card card) {
		cards.add(card);
	}
	public int getCardValue(int card) {
		return cards.get(card).getValue();
	}

	public void flipCard(int card) {
		cards.get(card).flip();
	}

	public int getCount() {
		return cards.size();
	}
	public Card discard(int card) {
		return cards.remove(card);
	}
	public void groupCards() {
		sortHand = new HashMap<>();
		for (Card card : cards) {
			if (sortHand.containsKey(card.getValue()))
				sortHand.put(card.getValue(),
						sortHand.get(card.getValue()) + 1);
			else
				sortHand.put(card.getValue(), 1);
		}
		System.out.println(sortHand);
		// return sortHand;
	}



	public void revealHand() {
		for (Card card : cards) {
			if (card.isFaceDown())
				card.flip();

			// System.out.print(card.toString() + " ");
		}
	}

	public void handFaceDown() {
		for (Card card : cards) {
			if (!(card.isFaceDown()))
				card.flip();

			// System.out.print(card.toString() + " ");
		}
	}
}
