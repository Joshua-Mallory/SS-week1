package com.ss.mar.day5.project;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RemoveXTest {
	RemoveX rm = new RemoveX();

	@Test
	public void removeXTest() {
		List<String> myStr = Arrays.asList("jotxxe", "axpe", "Davidian", "Axrt", "floundEr", "hoxrse", "apple", "ask",
				"asp", "Axnt");
		List<String> expected = Arrays.asList("jote", "ape", "Davidian", "Art", "floundEr", "horse", "apple", "ask",
				"asp", "Ant");
		assertArrayEquals(rm.removeX().toArray(), expected.toArray());
	}

	@Test
	public void removalTest() {
		assertEquals(rm.removal("stxm"), "stm");
		assertEquals(rm.removal("x"), "");
		assertEquals(rm.removal("xox"), "o");
		assertEquals(rm.removal(null), null);
		assertNotEquals(rm.removal("xxx"), "x");
		assertNotEquals(rm.removal("xox"), "ox");
	}

}
