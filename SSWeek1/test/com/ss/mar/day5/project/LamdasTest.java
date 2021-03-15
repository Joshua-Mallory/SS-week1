package com.ss.mar.day5.project;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class LamdasTest {
	Lambdas ld = new Lambdas();

	@Test
	public void evenOrOddArgTest() {
		assertTrue((ld.evenOrOddArg(0)).equals("0 EVEN"));
		assertTrue((ld.evenOrOddArg(1)).equals("1 ODD"));
		assertFalse((ld.evenOrOddArg(1)).equals("1 EVEN"));
		assertFalse((ld.evenOrOddArg(1)).equals("2 ODD"));
		assertNull(ld.evenOrOddArg(null));
	}

	@Test
	public void primeCompTest() {
		assertTrue((ld.primeComp(0)).equals("0 COMPOSITE"));
		assertTrue((ld.primeComp(1)).equals("1 COMPOSITE"));
		assertTrue((ld.primeComp(2)).equals("2 PRIME"));
		assertTrue((ld.primeComp(3)).equals("3 PRIME"));
		assertTrue((ld.primeComp(7)).equals("7 PRIME"));
		assertFalse((ld.primeComp(1)).equals("3 PRIME"));
		assertFalse((ld.primeComp(-3)).equals("-3 PRIME"));
		assertNull(ld.primeComp(null));
	}

	@Test
	public void isPalinCheckTest() {
		assertTrue((ld.isPalinCheck(0)).equals("0 PALINDROME"));
		assertTrue((ld.isPalinCheck(101)).equals("101 PALINDROME"));
		assertTrue((ld.isPalinCheck(100)).equals("100 NOT PALINDROME"));
		assertTrue((ld.isPalinCheck(555)).equals("555 PALINDROME"));
		assertTrue((ld.isPalinCheck(52325)).equals("52325 PALINDROME"));
		assertFalse((ld.isPalinCheck(52325)).equals("52325 NOT PALINDROME"));
		assertFalse((ld.isPalinCheck(-1)).equals("-1 PALINDROME"));
		assertFalse((ld.isPalinCheck(-555)).equals("-555 PALINDROME"));
		assertFalse((ld.isPalinCheck(9)).equals("9 NOT PALINDROME"));
		assertNull(ld.isPalinCheck(null));
	}

	@Test
	public void switcherTest() {
		List<Integer> myValues = Arrays.asList(5, 7, 912, 88, 99);
		AtomicInteger counter = new AtomicInteger(-1);

		assertTrue((ld.switcher(4, myValues, counter)).equals("Invalid Input"));
		counter.set(-1);
		assertTrue((ld.switcher(2, myValues, counter)).equals("5 PRIME"));
		counter.set(-1);
		assertFalse((ld.switcher(3, myValues, counter)).equals("5 PRIME"));
		counter.set(0);
		assertTrue((ld.switcher(1, myValues, counter)).equals("7 ODD"));
		counter.set(1);
		assertTrue((ld.switcher(3, myValues, counter)).equals("912 NOT PALINDROME"));
		counter.set(2);
		assertTrue((ld.switcher(2, myValues, counter)).equals("88 COMPOSITE"));
		counter.set(3);
		assertTrue((ld.switcher(1, myValues, counter)).equals("99 ODD"));
		counter.set(3);
		assertNull((ld.switcher(null, myValues, counter)));
		assertNull((ld.switcher(null, null, null)));

	}

	@Test
	public void lambdaWalkTest() {
		List<Integer> myValues = Arrays.asList(5, 7, 912, 88, 99);
		List<Integer> myCases = Arrays.asList(2, 1, 3, 2, 1);
		List<String> allList = ld.lambdaWalk(myCases, myValues);
		List<String> expected = Arrays.asList("5 PRIME", "7 ODD", "912 NOT PALINDROME", "88 COMPOSITE", "99 ODD");
		assertArrayEquals(allList.toArray(), expected.toArray());
		assertNull(ld.lambdaWalk(null, null));
		assertNull(ld.lambdaWalk(myCases, null));
	}

}
