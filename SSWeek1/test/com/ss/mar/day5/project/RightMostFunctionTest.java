package com.ss.mar.day5.project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RightMostFunctionTest {

	@Test
	public void rightMostFunctionTest() {
		RightMostFunction rm = temp2 -> (temp2 % 10);
		assertEquals(rm.calculate(55), 5);
		assertEquals(rm.calculate(890), 0);
		assertEquals(rm.calculate(0), 0);
	}

}
