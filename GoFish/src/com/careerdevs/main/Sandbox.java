package com.careerdevs.main;

import java.util.Random;

public class Sandbox {

	public static void main(String[] args) {
	Random rand=new Random();
	for (int idx=0; idx<10; idx++) {
	int number=rand.nextInt(10);
	System.out.println(number);
	}
	}

}
