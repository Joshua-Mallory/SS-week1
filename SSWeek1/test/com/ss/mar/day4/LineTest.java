package com.ss.mar.day4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.mar.day4.line.Line;

//there are so many lines to test for different conditions
public class LineTest {
	private Line line1 = new Line(1, 2, 1, 4);
	private Line line2 = new Line(1, 2, 3, 4);
	private Line line3 = new Line(1, 2, 1, 6);
	private Line line4 = new Line(1, 4, 2, 4);
	private Line line5 = new Line(1, 6, 2, 4);
	private Line line6 = new Line(2, 6, 2, 6);
	private Line line7 = new Line(1, 1, 2, 2);
	private Line line8 = new Line(1, 1, 2, 2);
	private Line line9 = new Line(2, 4, 3, 5);

	@Test
	public void getSlopeTest2() {
		assertEquals(1.0, line2.getSlope(), .0001);
		assertEquals(0.0, line4.getSlope(), .0001);
		assertEquals(-2.0, line5.getSlope(), .0001);
		assertNotEquals(2.0, line2.getSlope(), .0001);
		assertNotEquals(2.0, line4.getSlope(), .0001);
	}

	@Test(expected = ArithmeticException.class)
	public void getSlopeTest() {
		assertEquals(0, line1.getSlope(), .0001);
		assertEquals(0, line3.getSlope(), .0001);
		assertNotEquals(0, line1.getSlope(), .0001);
		assertNotEquals(0, line3.getSlope(), .0001);
	}

	@Test
	public void getDistanceTest() {

		assertEquals(2.23606797, line5.getDistance(), .0001);
		assertEquals(0.0, line6.getDistance(), .0001);
		assertEquals(2.0, line1.getDistance(), .0001);
		assertNotEquals(-2.0, line3.getDistance(), .0001);
		assertNotEquals(2.0, line4.getDistance(), .0001);

	}

	@Test
	public void getParallelToTest() {
		assertTrue(line8.parallelTo(line9));
		assertFalse(line8.parallelTo(line4));
		assertFalse(line7.parallelTo(line4));

	}

	@Test(expected = ArithmeticException.class)
	public void getParallelToTest2() {
		assertTrue(line6.parallelTo(line9));
	}
}
