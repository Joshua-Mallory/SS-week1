package com.ss.mar.day5.project;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LambdaFunctionTest {

	@Test
	public void LambdaFunctionTest() {
		LambdaFunction lf = temp2 -> (temp2 % 2) == 0;
		assertTrue(lf.calculate(4));
	}

}
