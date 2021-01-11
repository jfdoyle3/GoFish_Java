package com.jfdeveloper.actors;

import java.util.Random;

public class Dealer implements Actor {
	private Random rand;  
	static String NAME="HAL9000";
	//static int ASK=1;
	//static int GOFISH=2;

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public int getAction(int handSize) {
		rand = new Random();
		int number=rand.nextInt(handSize);
		return number;
	}
	

}
