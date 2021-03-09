/**
 * 
 */
package com.ss.mar.guessing;

/**
 * @author jcmal
 *
 */
public class GuessDriver {

	/**
	 * user gets 5 tries to guess a random number
	 */
	public static void main(String[] args) {
		GuessUser newGuess=new GuessUser();
		newGuess.guessInt();
	}

}
