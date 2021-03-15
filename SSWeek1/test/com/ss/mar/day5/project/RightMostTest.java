package com.ss.mar.day5.project;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RightMostTest {
	RightMost rm = new RightMost();

	@Test
	public void rightTest() {
		List<Integer> myInt = Arrays.asList(0, 1, 15, 39, 199, 2005);
		List<Integer> expected = Arrays.asList(0, 1, 5, 9, 9, 5);
		assertArrayEquals(rm.right().toArray(), expected.toArray());
	}

	@Test
	public void onRightTest() {
		assertEquals(rm.onRight(5), 5);
		assertEquals(rm.onRight(12), 2);
		assertEquals(rm.onRight(126), 6);
		assertNotEquals(rm.onRight(0), 5);
		assertEquals(rm.onRight(null), -99999);
	}

}
