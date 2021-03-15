/**
 * 
 */
package com.ss.mar.day5.project;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jcmal
 *
 */
public class RightMost {

	public static void main(String[] args) {
		RightMost rt = new RightMost();
		rt.right();
	}

	// performs operation to get the rightmost integer
	public static int onRight(Integer temp1) {
		if (temp1 >= 0 && temp1 != null) {
			RightMostFunction rm = temp2 -> (temp2 % 10);
			return rm.calculate(temp1);
		} else
			return temp1;
	}

	// begins stream to return a list of rightmost integers
	public List<Integer> right() {

		List<Integer> myInt = Arrays.asList(0, 1, 15, 39, 199, 2005);
		List<Integer> rightMost = myInt.stream().map(temp1 -> onRight(temp1)).collect(Collectors.toList());
		rightMost.forEach(System.out::println);
		return rightMost;
	}
}
