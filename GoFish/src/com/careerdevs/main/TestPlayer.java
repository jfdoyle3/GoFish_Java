package com.careerdevs.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestPlayer {

	public static void main(String[] args) {
	
		HashMap<String, Integer> hashPlayer=new HashMap<>();
		List<ArrayList<Integer>> listPlayer=new ArrayList<ArrayList<Integer>>();
		// HashMap
		
		
		
		
		//List
		ArrayList<Integer> hand1=new ArrayList<Integer>();
		hand1.add(1);
		hand1.add(3);
		hand1.add(4);
		hand1.add(7);
		hand1.add(9);
		hand1.add(8);
		listPlayer.add(hand1);
		
		ArrayList<Integer> hand2=new ArrayList<>();
		hand2.add(2);
		hand2.add(6);
		hand2.add(5);
		hand2.add(8);
		hand2.add(1);
		hand2.add(4);
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
