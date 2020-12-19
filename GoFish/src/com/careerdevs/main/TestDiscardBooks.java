package com.careerdevs.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class TestDiscardBooks {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(3, 4);
		hm.put(4, 4);
		hm.put(5, 2);
		hm.put(6, 4);
		hm.put(2, 2);
		hm.put(1, 1);

		// User Input
		// System.out.println("Hand: "+hm);
		// System.out.println("key ");
		// int key=input.nextInt();
		// System.out.println("value ");
		// int value=input.nextInt();
		// hm.put(key, value);
		System.out.println("Hand: " + hm);

		int books = findBooks(hm);

		System.out.println("Books: " + books);
		System.out.println("Hand: " + hm);
		System.out.println("end of line");
	}
	public static int findBooks(HashMap<Integer, Integer> hm) {

		for (Entry<Integer, Integer> entry : hm.entrySet()) {
			if (entry.getValue() >=2) {
				// hm.remove(entry.getKey());
				System.out.println("card: " + entry.getKey());
			}
			// System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		// if (key == 4) {
		//
		// // return entry.getKey();
		// System.out.println("Found at key: "+entry.getKey());
		// }
		// // System.out.println("Key : " + entry.getKey() + " Value : "+
		// entry.getValue());
		// }
		return 1;
	}

}
