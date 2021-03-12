package com.ss.mar.day4.deadlock;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DeadlockTest {
	Runnable thread1, thread2, thread3;
	Deadlock d = new Deadlock(1, 2, 3, thread1, thread2, thread3);
	Deadlock dfail = new Deadlock(1, 1, 1, thread1, thread2, thread3);

	@Test
	public void setupTest() {
		assertTrue(d.setup());

	}

	@Test(expected = Exception.class)
	public void FinishLineTest() {
		assertTrue(d.FinishLine(thread1, thread2, thread3));
	};

}
