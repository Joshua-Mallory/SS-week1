package com.ss.mar.day4.buffer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BufferTest {
	Runnable thread1, thread2;
	Buffer b = new Buffer(thread1, thread2);

	@Test
	public void wrapTest() {
		assertTrue(b.wrap());
	}

	@Test(expected = Exception.class)
	public void ThreadRunTest() {
		assertTrue(b.ThreadRun(thread1, thread2));
	}

}
