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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RightMost rt = new RightMost();
		List<Integer> myInt = Arrays.asList(0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
				22, 23, 555, 5555);
		rt.right(myInt);
	}

	public static int onRight(Integer temp1) {
		return temp1 % 10;
	}

	public List<Integer> right(List<Integer> myInt) {
		List<Integer> rightMost = myInt.stream().map(temp1 -> onRight(temp1)).collect(Collectors.toList());
		rightMost.forEach(System.out::println);
		return rightMost;
	}
}
