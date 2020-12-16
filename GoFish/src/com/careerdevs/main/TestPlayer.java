package com.careerdevs.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.careerdevs.cards.Card;
import com.careerdevs.cards.Deck;
import com.careerdevs.cards.GameDeck;

public class TestPlayer {

	public static void main(String[] args) {
	
		HashMap<String, Integer> hashPlayer=new HashMap<>();
		List<ArrayList<Card>> listPlayer=new ArrayList<ArrayList<Card>>();
		Deck deck=new GameDeck();
		deck.shuffle();
		// HashMap
		
		
		
		
		//List
		ArrayList<Card> hand1=new ArrayList<Card>();
		hand1.add(deck.draw(true));
		hand1.add(deck.draw(true));
		hand1.add(deck.draw(true));
		hand1.add(deck.draw(true));
		hand1.add(deck.draw(true));
		hand1.add(deck.draw(true));
		listPlayer.add(hand1);
		
		ArrayList<Card> hand2=new ArrayList<Card>();
		hand2.add(deck.draw(true));
		hand2.add(deck.draw(true));
		hand2.add(deck.draw(true));
		hand2.add(deck.draw(true));
		hand2.add(deck.draw(true));
		listPlayer.add(hand2);
		
//		listPlayer.forEach((list)->
//		{
//			list.forEach((hand)->System.out.print(hand));
//			
//		});
		
		System.out.println(listPlayer.get(0).toString());
		
		
		System.out.println("end of line");
	}

}
