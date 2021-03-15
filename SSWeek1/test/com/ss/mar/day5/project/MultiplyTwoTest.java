package com.ss.mar.day5.project;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MultiplyTwoTest {
	MultiplyTwo mt = new MultiplyTwo();

	@Test
	public void rightTest() {
		MultiplyTwoFunction lf = temp2 -> (temp2 * 2);
		List<Integer> expected = Arrays.asList(-100, 0, 2, 4, 20, 100, 200, 202);
		assertArrayEquals(mt.right().toArray(), expected.toArray());
	}

	@Test
	public void timesTwoTest() {

		assertEquals(mt.timesTwo(5), 10);
		assertEquals(mt.timesTwo(-5), -10);
		assertNotEquals(mt.timesTwo(6), 10);
		assertNotEquals(mt.timesTwo(-5), 10);
		assertEquals(mt.timesTwo(0), 0);
		assertEquals(mt.timesTwo(null), -99999);
	}

}
