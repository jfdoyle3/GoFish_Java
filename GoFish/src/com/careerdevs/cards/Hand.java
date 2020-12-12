package com.careerdevs.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.careerdevs.actors.Actor;

public class Hand {

	private List<Card> cards = new ArrayList<>();
	private HashMap<Integer, Integer> sortHand = new HashMap<>();
	private Actor actor;
	public int bet;

	public Hand(Actor actor) {
		this.actor = actor;
	}

	public String getName() {
		return actor.getName();
	}

	// TODO: add a constructor takes one card for a split;
	public Actor getActor() {
		return actor;
	}

	public void getCard(Card card) {
		cards.add(card);
	}

	public int getBet() {
		return actor.setBet();
	}

	public int getCount() {
		return cards.size();
	}

	public void groupCards() {
		for (Card card : cards) {
			if (sortHand.containsKey(card.getValue()))
				sortHand.put(card.getValue(), sortHand.get(card.getValue()) + 1);
			else
				sortHand.put(card.getValue(), 1);
		}
		System.out.println(sortHand.toString());
	}


	public void showHand() {
		Collections.sort();
	}
}
