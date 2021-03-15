package com.ss.mar.day5.project;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplyTwo {

	public static void main(String[] args) {
		List<Integer> myInt = Arrays.asList(0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
				22, 23, 555, 5555);
		right(myInt);
	}

	public static int timesTwo(Integer temp1) {
		return temp1 * 2;
	}

	public static void right(List<Integer> myInt) {
		List<Integer> multiply = myInt.stream().map(temp1 -> timesTwo(temp1)).collect(Collectors.toList());
		multiply.forEach(System.out::println);
	}

}
