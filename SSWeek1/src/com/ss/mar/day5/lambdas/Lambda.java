/**
 * 
 */
package com.ss.mar.day5.lambdas;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author jcmal
 *
 */
public class Lambda {
	// sets up comparators and predicates to be used as arguments and begins
	// function calls
	public boolean Setup(List<String> myStr, List<Integer> myInt, List<String> myStrA) {
		boolean valid = false;
		if (myStr != null && myInt != null && myStrA != null) {
			valid = true;
			Comparator<String> compByLength = (temp1, temp2) -> temp1.length() - temp2.length();
			Comparator<String> compByReverseLength = (temp1, temp2) -> temp2.length() - temp1.length();
			Comparator<String> compAlphaFirst = (temp1, temp2) -> Character.toLowerCase(temp1.charAt(0))
					- Character.toLowerCase(temp2.charAt(0));
			Comparator<String> compStringsECurly = (temp1, temp2) -> {
				if (temp1.contains("e") || temp1.contains("E")) {
					return myStr.indexOf(temp2) - myStr.indexOf(temp1);
				} else
					return 0;
			};

			Predicate<String> predStringsEUtil = temp1 -> temp1.contains("e") || temp1.contains("E");
			Predicate<String> predStringsNoE = temp1 -> !temp1.contains("e") && !temp1.contains("E");
			System.out.println("Sorted by string length short to long");
			sortedStruct(myStr, compByLength);
			System.out.println("Sorted by string length long to short");
			sortedStruct(myStr, compByReverseLength);
			System.out.println("Sorted Alphabetically");
			sortedStruct(myStr, compAlphaFirst);
			System.out.println("Sorted if contains e or E first without Utils");
			sortedStruct(myStr, compStringsECurly);
			System.out.println("Sorted if contains e or E first with Utils");
			sortWUtils(myStr, predStringsEUtil, predStringsNoE);
			System.out.println("Append e or o for even or odd");
			evenOrOdd(myInt);
			Predicate<String> predStartsWithA = temp1 -> temp1.charAt(0) == 'a' && temp1.length() == 3;
			System.out.println("Only display 3 letter string starting with a");
			sortForA(myStrA, predStartsWithA);
		}
		return valid;

	}

	// determins if a string is even or odd and appends
	public String evenOrOddArg(Integer temp1) {

		if (temp1 % 2 == 0)
			return "e" + temp1.toString();

		return "o" + temp1.toString();

	}

	// used with multiple comparators to perform varios operations
	public List<String> sortedStruct(List<String> myStr, Comparator<String> comp) {

		List<String> sortedMyStr = myStr.stream().sorted(comp).collect(Collectors.toList());
		printList(sortedMyStr);

		// sortedMyStr.forEach(System.out::println);
		return sortedMyStr;
	}

	// uses built in utilitys to sort
	public List<String> sortWUtils(List<String> myStr, Predicate<String> pred, Predicate<String> predNoE) {
		List<String> sortedMyStrE = myStr.stream().filter(pred).collect(Collectors.toList());
		List<String> sortedMyStrNoE = myStr.stream().filter(predNoE).collect(Collectors.toList());
		sortedMyStrE.addAll(sortedMyStrNoE);
		// sortedMyStrE.forEach(System.out::println);
		printList(sortedMyStrE);
		return sortedMyStrE;
	}

	// begins the evenOrOdd functioning and outputs back into one string
	public String evenOrOdd(List<Integer> myInt) {
		StringBuilder fin = new StringBuilder();
		AtomicInteger counter = new AtomicInteger();
		myInt.stream().map(temp1 -> evenOrOddArg(temp1)).forEach(temp1 -> {
			if (counter.getAndIncrement() != myInt.size() - 1) {
				fin.append(temp1 + ",");
			} else {
				fin.append(temp1);
			}
		});
		System.out.print(fin);
		System.out.println();
		System.out.println();
		return fin.toString();

	}

	// sorts out strings that start with "a" and are 3 letters
	public List<String> sortForA(List<String> myStr, Predicate<String> pred) {
		List<String> sortedByA3 = myStr.stream().filter(pred).collect(Collectors.toList());
		// sortedByA3.forEach(System.out::println);
		printList(sortedByA3);
		return sortedByA3;
	}

	// print form used for multilple functions
	public boolean printList(List<String> myStr) {
		if (myStr != null) {
			myStr.forEach(System.out::println);
			System.out.println();
			return true;
		}
		return false;
	}
}
