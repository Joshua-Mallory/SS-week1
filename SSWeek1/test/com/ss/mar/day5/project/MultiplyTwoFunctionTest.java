package com.ss.mar.day5.project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultiplyTwoFunctionTest {

	@Test
	public void MultiplyTwoFunctionTest() {
		MultiplyTwoFunction lf = temp2 -> (temp2 * 2);
		assertEquals(lf.calculate(5).intValue(), 10);
	}

}
