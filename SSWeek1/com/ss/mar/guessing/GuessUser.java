/**
 * 
 */
package com.ss.mar.guessing;

import java.util.Random;
import java.util.Scanner;

/**
 * @author jcmal
 *
 */
public class GuessUser {
	//generates number, tests to see if user input is within range of number, prints appropriate messages
	public void guessInt() {
		Scanner numIn = new Scanner(System.in);
		Random gen = new Random(); 
		int testNum=gen.nextInt(100)+1;
		int guess=111,tries=0;
		do {
			if (tries > 0 && guess !=111) 
				System.out.println("Incorrect, try again");
			else
				System.out.println("Enter an integer between 1-100");
			guess=scanHandle(numIn);
			while(guess<=0 || guess>100) {
				System.out.println("Invalid input, enter an integer between 1-100, try again.");
				guess=scanHandle(numIn);
			}
			tries++;
		}
		while (tries<5 && (guess<testNum-10 || guess>testNum+10));
		if (tries==5 && (guess<testNum-10 || guess>testNum+10)) {
			System.out.println("Sorry, the number is " + testNum + ".");	
		}
		else {
			System.out.println("Your number is within plus or minus 10 of the random number.");
			System.out.println("The random number is " + testNum + ".");
		}
	}
	//handle non integer inputs
	public int scanHandle(Scanner numIn) {
		int guess=111;
		try {
			guess=numIn.nextInt();
			} 
			catch (Exception e) { 
				numIn.nextLine();
			}
		return guess;
	}
}
