package com.ss.mar.day5.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class RemoveXFunctionTest {

	@Test
	public void removeXFunctionTest() {
		RemoveXFunction lf = temp2 -> temp2.replaceAll("x", "");
		assertEquals(lf.calculate("tox"), "to");
		assertNotEquals(lf.calculate("tox"), "tox");
	}

}
