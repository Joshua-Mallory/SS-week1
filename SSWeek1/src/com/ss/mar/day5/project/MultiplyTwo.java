package com.ss.mar.day5.project;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplyTwo {

	public static void main(String[] args) {

		MultiplyTwo mt = new MultiplyTwo();
		mt.right();
	}

	// performs operation, implements functional interface
	public int timesTwo(Integer temp1) {
		if (temp1 != null) {
			MultiplyTwoFunction lf = temp2 -> (temp2 * 2);
			return lf.calculate(temp1);
		} else
			return temp1;
	}

	// begins operations on given array
	public List<Integer> right() {
		List<Integer> myInt = Arrays.asList(-50, 0, 1, 2, 10, 50, 100, 101);
		List<Integer> multiply = myInt.stream().map(temp1 -> timesTwo(temp1)).collect(Collectors.toList());
		multiply.forEach(System.out::println);
		return multiply;
	}

}
