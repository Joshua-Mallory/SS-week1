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
	public void Setup(List<String> myStr, List<Integer> myInt, List<String> myStrA) {

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
		Predicate<String> predStartsWithA = temp1 -> temp1.charAt(0) == 'a' && temp1.length() == 3;
		Predicate<String> predStringsEUtil = temp1 -> temp1.contains("e") || temp1.contains("E");
		Predicate<String> predStringsNoE = temp1 -> !temp1.contains("e") && !temp1.contains("E");
		Predicate<Integer> predEvenOrOdd = temp1 -> (temp1 % 2) == 0;
		System.out.println("Sorted by string length short to long");
		SortedStruct(myStr, compByLength);
		System.out.println("Sorted by string length long to short");
		SortedStruct(myStr, compByReverseLength);
		System.out.println("Sorted Alphabetically");
		SortedStruct(myStr, compAlphaFirst);
		System.out.println("Sorted if contains e or E first without Utils");
		SortedStruct(myStr, compStringsECurly);
		System.out.println("Sorted if contains e or E first with Utils");
		SortWUtils(myStr, predStringsEUtil, predStringsNoE);
		System.out.println("Append e or o for even or odd");
		EvenOrOdd(myInt);
		System.out.println("Only display 3 letter string starting with a");
		SortForA(myStrA, predStartsWithA);

	}

	public static String EvenOrOddArg(Integer temp1) {

		if (temp1 % 2 == 0)
			return "e" + temp1.toString();

		return "o" + temp1.toString();

	}

	public static void SortedStruct(List<String> myStr, Comparator<String> comp) {
		List<String> sortedMyStr = myStr.stream().sorted(comp).collect(Collectors.toList());
		printString(sortedMyStr);
		// sortedMyStr.forEach(System.out::println);
	}

	public static void SortWUtils(List<String> myStr, Predicate<String> pred, Predicate<String> predNoE) {
		List<String> sortedMyStrE = myStr.stream().filter(pred).collect(Collectors.toList());
		List<String> sortedMyStrNoE = myStr.stream().filter(predNoE).collect(Collectors.toList());
		sortedMyStrE.addAll(sortedMyStrNoE);
		// sortedMyStrE.forEach(System.out::println);
		printString(sortedMyStrE);
	}

	public static void EvenOrOdd(List<Integer> myInt) {
		StringBuilder fin = new StringBuilder();
		AtomicInteger counter = new AtomicInteger();
		myInt.stream().map(temp1 -> EvenOrOddArg(temp1)).forEach(temp1 -> {
			if (counter.getAndIncrement() != myInt.size() - 1) {
				fin.append(temp1 + ",");
			} else {
				fin.append(temp1);
			}
		});
		System.out.print(fin);
		System.out.println();
		System.out.println();
	}

	public static void SortForA(List<String> myStr, Predicate<String> pred) {
		List<String> sortedByA3 = myStr.stream().filter(pred).collect(Collectors.toList());
		// sortedByA3.forEach(System.out::println);
		printString(sortedByA3);
	}

	public static boolean printString(List<String> myStr) {
		myStr.forEach(System.out::println);
		System.out.println();
		return false;
	}
}
