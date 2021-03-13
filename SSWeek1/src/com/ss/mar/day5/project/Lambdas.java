package com.ss.mar.day5.project;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambdas {
	public static void main(String[] args) {
		List<String> myStr = Arrays.asList("johnst", "karen", "Davidian", "floundEr", "horse", "cow");
		List<Integer> myInt = Arrays.asList(-2, 0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
				21, 22, 23, 555, 5555);
		List<String> myStrA = Arrays.asList("jote", "ape", "Davidian", "Art", "floundEr", "horse", "apple", "ask",
				"asp", "Ant");
		evenOrOdd(myInt);
		primeOrComp(myInt);
		isPal(myInt);
	}

	public static String EvenOrOddArg(Integer temp1) {

		if (temp1 % 2 == 0)
			return temp1 + " " + "Even";

		return temp1 + " " + "Odd";

	}

	public static String primeComp(Integer temp1) {
		boolean prime = true;
		for (int i = 2; i <= temp1 / 2; i++) {
			if (temp1 % i == 0)
				prime = false;
		}
		if (temp1 < 2)
			prime = false;
		if (prime == true)
			return temp1 + " " + "Prime";

		return temp1 + " " + "Composite";

	}

	public static String isPalinCheck(Integer temp1) {
		if (temp1 != 0 || temp1 != 1) {
			int i = 0;
			String numStr = (Integer.toString(temp1));
			Integer j = numStr.length();
			while (i < j) {
				if (numStr.charAt(i) != numStr.charAt(j - 1)) {
					return temp1 + " " + "Not Palindrome";
				}
				i++;
				j--;
			}
		}
		return temp1 + " " + "Is Palindrome";
	}

	public static void evenOrOdd(List<Integer> myInt) {
		List<String> evenOddList = myInt.stream().map(temp1 -> EvenOrOddArg(temp1)).collect(Collectors.toList());
		evenOddList.forEach(System.out::println);
	}

	public static void primeOrComp(List<Integer> myInt) {
		List<String> primeOrComp = myInt.stream().map(temp1 -> primeComp(temp1)).collect(Collectors.toList());
		primeOrComp.forEach(System.out::println);
	}

	public static void isPal(List<Integer> myInt) {
		List<String> palindrome = myInt.stream().map(temp1 -> isPalinCheck(temp1)).collect(Collectors.toList());
		palindrome.forEach(System.out::println);
	}
}
