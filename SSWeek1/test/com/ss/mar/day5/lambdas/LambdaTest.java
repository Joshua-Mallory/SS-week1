package com.ss.mar.day5.lambdas;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

public class LambdaTest {
	Lambda l = new Lambda();
	List<String> myStr = Arrays.asList("johnst", "karen", "Davidian", "floundEr", "horse", "cow");
	List<Integer> myInt = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	List<String> myStrA = Arrays.asList("jote", "ape", "Davidian", "Art", "floundEr", "horse", "apple", "ask", "asp",
			"Ant");

	@Test
	public void setupTest() {
		assertTrue(l.Setup(myStr, myInt, myStrA));
		assertFalse(l.Setup(null, myInt, myStrA));
		assertFalse(l.Setup(myStr, null, myStr));
		assertFalse(l.Setup(myStr, myInt, null));
		assertFalse(l.Setup(null, null, null));
	}

	@Test
	public void evenOrOddArgTest() {
		assertTrue("e2".equals(l.evenOrOddArg(2)));
		assertTrue("o1".equals(l.evenOrOddArg(1)));
		assertFalse("e1".equals(l.evenOrOddArg(1)));
		assertFalse("e2".equals(l.evenOrOddArg(1)));
		assertFalse("o2".equals(l.evenOrOddArg(1)));
		assertFalse("o1".equals(l.evenOrOddArg(2)));
		assertTrue("e0".equals(l.evenOrOddArg(0)));
		assertTrue("o-1".equals(l.evenOrOddArg(-1)));
		assertTrue("e-2".equals(l.evenOrOddArg(-2)));
		assertFalse("e1".equals(l.evenOrOddArg(-1)));
		assertFalse("o-2".equals(l.evenOrOddArg(-2)));

	}

	@Test
	public void sortedStructTest() {
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
		List<String> myStrLen = Arrays.asList("cow", "karen", "horse", "johnst", "Davidian", "floundEr");
		assertArrayEquals((myStrLen.toArray()), l.sortedStruct(myStr, compByLength).toArray());
		List<String> myStrLenRev = Arrays.asList("Davidian", "floundEr", "johnst", "karen", "horse", "cow");
		assertArrayEquals((myStrLenRev.toArray()), l.sortedStruct(myStr, compByReverseLength).toArray());
		List<String> myStrAlpha = Arrays.asList("cow", "Davidian", "floundEr", "horse", "johnst", "karen");
		assertArrayEquals((myStrAlpha.toArray()), l.sortedStruct(myStr, compAlphaFirst).toArray());
		List<String> myECurly = Arrays.asList("horse", "floundEr", "karen", "johnst", "Davidian", "cow");
		assertArrayEquals((myECurly.toArray()), l.sortedStruct(myStr, compStringsECurly).toArray());
	}

	@Test
	public void sortWUtilsTest() {
		Predicate<String> predStringsEUtil = temp1 -> temp1.contains("e") || temp1.contains("E");
		Predicate<String> predStringsNoE = temp1 -> !temp1.contains("e") && !temp1.contains("E");
		List<String> myStrE = Arrays.asList("karen", "floundEr", "horse", "johnst", "Davidian", "cow");
		assertArrayEquals((myStrE.toArray()), l.sortWUtils(myStr, predStringsEUtil, predStringsNoE).toArray());
	}

	@Test
	public void evenOrOddTest() {
		assertTrue(l.evenOrOdd(myInt).equals("e0,o1,e2,o3,e4,o5,e6,o7,e8,o9,e10"));
		assertFalse(l.evenOrOdd(myInt).equals("o0,o1,e2,o3,e4,o5,e6,o7,e8,o9,e10"));
		assertFalse(l.evenOrOdd(myInt).equals(null));
	}

	@Test
	public void sortForATest() {
		Predicate<String> predStartsWithA = temp1 -> temp1.charAt(0) == 'a' && temp1.length() == 3;
		List<String> myStrA2 = Arrays.asList("ape", "ask", "asp");
		assertArrayEquals((myStrA2.toArray()), l.sortForA(myStrA, predStartsWithA).toArray());
	}

	@Test
	public void printListTest() {
		assertTrue(l.printList(myStr));
		assertFalse(l.printList(null));
	}
}
