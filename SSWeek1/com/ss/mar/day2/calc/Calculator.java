/**
 * 
 */
package com.ss.marday2.calc;

/**
 * @author jcmal
 *
 */
//parses the arguments of a string array as doubles, exits program if invalid input
public class Calculator {

	public void calc(String args2[]) {
		double total = 0.0;
		for (int i = 0; i < args2.length; i++) {
			double current = 0.0;
			try {
				current = Double.parseDouble(args2[i]);
			} catch (Exception e) {
				System.out.println("Invalid input. Exiting Program");
				System.exit(0);
			}
			total = total + current;
		}
		System.out.println(total);
	}
}
