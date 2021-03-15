package com.ss.mar.day5.project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
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

	public String EvenOrOddArg(Integer temp1) {

		if (temp1 % 2 == 0)
			return temp1 + " " + "EVEN";

		return temp1 + " " + "ODD";

	}

	public String primeComp(Integer temp1) {
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

	}

	public String isPalinCheck(Integer temp1) {
		if (temp1 != 0 || temp1 != 1) {
			int i = 0;
			String numStr = (Integer.toString(temp1));
			Integer j = numStr.length();
			while (i < j) {
				if (numStr.charAt(i) != numStr.charAt(j - 1)) {
					return temp1 + " " + "PALINDROME";
				}
				i++;
				j--;
			}
		}
		return temp1 + " " + "NOT PALINDROME";
	}

	public String switcher(Integer temp1, List<Integer> myValues, AtomicInteger counter) {
		counter.getAndIncrement();
		if (temp1 == 1) {
			return EvenOrOddArg(myValues.get(counter.get()));
		} else if (temp1 == 2) {
			return primeComp(myValues.get(counter.get()));
		} else if (temp1 == 3) {
			return isPalinCheck(myValues.get(counter.get()));
		} else {
			return "Invalid Input";
		}

	}

	public void lambdaWalk(List<Integer> myCases, List<Integer> myValues) {
		AtomicInteger counter = new AtomicInteger(-1);
		List<String> evenOddList = myCases.stream().map(temp1 -> switcher(temp1, myValues, counter))
				.collect(Collectors.toList());
		evenOddList.forEach(System.out::println);

	}

}
