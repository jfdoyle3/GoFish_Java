package com.careerdevs.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.careerdevs.actors.Actor;

public class Hand {

	private HashMap<String, List<Card>> players = new HashMap<>();
	private List<Card> cards = new ArrayList<>();
	private HashMap<Integer, Integer> sortHand;
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

	public  Card askForCards(int cardLoc) {
		Card cardAsked = cards.get(cardLoc);
		if (cards.indexOf(cardAsked)>0) {
			 cards.remove(cardAsked);
				return cardAsked;
		} else {
			System.out.println("no Cards- go fish");
			return null;
		}
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
