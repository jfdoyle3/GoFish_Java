package com.careerdevs.actors;

import java.util.ArrayList;
import java.util.List;

import com.careerdevs.cards.Card;
import com.careerdevs.cards.Deck;

public class Dealer implements Actor {
	static String NAME="Dealer";
	static int DECISION=17;
	static int HIT=1;
	static int STAND=2;

	@Override
	public String getName() {
		return NAME;
	}



	@Override
	public int getAction(int score) {
		//return score<DECISION ? HIT:STAND;
		 if (score< 17) { 
			 return 1;
		 }else {
			 return 2;
		 }
	}
	

}
