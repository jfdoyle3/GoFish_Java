package com.careerdevs.objects;

import com.careerdevs.actors.Actor;
import com.careerdevs.cards.Card;
import com.careerdevs.ui.Console;

public class BlackJack {
	
	private  Table table=new Table();
	
	public  void play() {
		
		table.getDeck().shuffle();

		table.getDealers().getCard(table.getDeck().draw());
		table.getDealers().getCard(table.getDeck().draw());
	
		displayTable();
		
		Actor dealer=table.getDealers().getActor();
	//	int choice=dealer.getAction(table.getDealers().addUpCards());
		
		

		System.out.println("\nend of Line");
	}

	private void displayTable() {
		System.out.print(table.getDealers().getName() + " -> ");
		table.getDealers().showHand();
	//	System.out.println(" Hand total: " + table.getDealers().addUpCards());
	}
	
	
}
