package com.ss.mar.day5.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RecursionSumTest {
	RecursionSum rs = new RecursionSum();

	@Test
	public void groupSumClump() {
		List<Integer> myInt = Arrays.asList(1, 2, 3, 4);
		List<Integer> myIntCon = Arrays.asList(1, 2, 2, 3, 4);
		assertTrue(rs.groupSumClump(myInt, 0, 6));
		assertFalse(rs.groupSumClump(myInt, 0, 11));
		assertTrue(rs.groupSumClump(myIntCon, 0, 7));
		assertFalse(rs.groupSumClump(myIntCon, 0, 6));
	}

	@Test
	public void findSumTest() {
		List<Integer> myInt = Arrays.asList(1, 2, 2, 3, 4);
		int[] data = rs.findSum(myInt, 2);
		int[] data2 = rs.findSum(myInt, 1);
		System.out.println(data2[0]);
		assertEquals(data2[0], 4);
		assertEquals(data2[1], 3);
		assertNotEquals(data[0], 4);
		assertNotEquals(data[1], 2);
	}

}
