/**
 * 
 */
package com.ss.mar.day5.project;

import java.util.Arrays;
import java.util.List;

/**
 * @author jcmal
 *
 */
public class RecursionSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> myInt = Arrays.asList(1, 2, 2, 5, 6, 6);
		Integer target = 13;
		Integer index = 0;
		if (groupSumClump(myInt, index, target))
			System.out.println("Integers add up to target");
		else
			System.out.println("Integers do not add up to target");

	}

	public static int[] findSum(List<Integer> myInt, Integer index) {
		Integer sameCheck = myInt.get(index);
		Integer totalSame = 0;
		while (index < myInt.size() && sameCheck == myInt.get(index)) {
			totalSame = totalSame + myInt.get(index);
			index++;
		}
		int[] data = { totalSame, index };
		return data;
	}

	public static boolean groupSumClump(List<Integer> myInt, int index, int target) {
		if (index >= myInt.size())
			return (target == 0);

		int[] data = findSum(myInt, index);

		if (groupSumClump(myInt, data[1], target - data[0]))
			return true;

		return groupSumClump(myInt, data[1], target);
	}
}
