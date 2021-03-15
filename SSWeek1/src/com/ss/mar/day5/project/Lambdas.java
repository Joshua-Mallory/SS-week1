package com.ss.mar.day5.project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lambdas {
	public static void main(String[] args) {
		FileReader fileLoc = null;
		try {
			fileLoc = new FileReader("testLambda.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Invalid File");
			System.exit(0);
		}
		LambdaReader lr = new LambdaReader();
		lr.reader(fileLoc);

	}

	public String evenOrOddArg(Integer temp1) {
		if (temp1 != null) {
			if (temp1 % 2 == 0)
				return temp1 + " " + "EVEN";

			return temp1 + " " + "ODD";
		} else
			return null;
	}

	public String primeComp(Integer temp1) {
		if (temp1 != null) {
			boolean prime = true;
			for (int i = 2; i <= temp1 / 2; i++) {
				if (temp1 % i == 0)
					prime = false;
			}
			if (temp1 < 2)
				prime = false;
			if (prime == true)
				return temp1 + " " + "PRIME";

			return temp1 + " " + "COMPOSITE";
		} else
			return null;
	}

	public String isPalinCheck(Integer temp1) {
		if (temp1 != null) {
			if (temp1 != 0 || temp1 != 1) {
				int i = 0;
				String numStr = (Integer.toString(temp1));
				Integer j = numStr.length();
				while (i < j) {
					if (numStr.charAt(i) != numStr.charAt(j - 1)) {
						return temp1 + " " + "NOT PALINDROME";
					}
					i++;
					j--;
				}
			}
			return temp1 + " " + "PALINDROME";
		} else
			return null;
	}

	public String switcher(Integer temp1, List<Integer> myValues, AtomicInteger counter) {
		if (temp1 != null && myValues != null && counter != null) {
			counter.getAndIncrement();
			if (temp1 == 1) {
				return evenOrOddArg(myValues.get(counter.get()));
			} else if (temp1 == 2) {
				return primeComp(myValues.get(counter.get()));
			} else if (temp1 == 3) {
				return isPalinCheck(myValues.get(counter.get()));
			} else {
				return "Invalid Input";
			}
		} else
			return null;
	}

	public List<String> lambdaWalk(List<Integer> myCases, List<Integer> myValues) {
		if (myCases != null && myValues != null) {

			AtomicInteger counter = new AtomicInteger(-1);
			Function<Integer, String> fun = (temp1 -> switcher(temp1, myValues, counter));
			List<String> allList = myCases.stream().map(fun).collect(Collectors.toList());
			allList.forEach(System.out::println);
			return allList;
		} else
			return null;
	}

}
