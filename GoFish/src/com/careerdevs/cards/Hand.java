package com.careerdevs.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.careerdevs.actors.Actor;
import com.careerdevs.ui.Input;

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
	
	public Card getCard(int index) {
		return cards.get(index);
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

	// TODO: use GroupCard to find books and use key to remove from hand.
//	public HashMap<Integer,Integer> groupCards() {
//		sortHand = new HashMap<>();
//		for (Card card : cards) {
//			if (sortHand.containsKey(card.getValue()))
//				sortHand.put(card.getValue(),
//						sortHand.get(card.getValue()) + 1);
//			else
//				sortHand.put(card.getValue(), 1);
//		}
//		System.out.println(sortHand);
//		 return sortHand;
//	}

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
		}
	}

	// TODO: bubble sort cards ...

	// TODO: for loop thru cards and find index or remove from hand to add to
	// new hand or discard for multiple cards to be xfered.
	public void findCards(int cardValue) {
		for (int idx = 0; idx < getCount(); idx++) {
			if (getCardValue(idx) == cardValue) {
				flipCard(idx);
			}

		}
	}

}
