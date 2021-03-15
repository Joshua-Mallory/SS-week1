/**
 * 
 */
package com.ss.mar.day5.lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * @author jcmal
 *
 */
public class LambdaDriver {

	// performs a number of operations implementing lambda functions
	public static void main(String[] args) {
		List<String> myStr = Arrays.asList("johnst", "karen", "Davidian", "floundEr", "horse", "cow");
		List<Integer> myInt = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<String> myStrA = Arrays.asList("jote", "ape", "Davidian", "Art", "floundEr", "horse", "apple", "ask",
				"asp", "Ant");
		Lambda l = new Lambda();
		l.Setup(myStr, myInt, myStrA);
	}

}
