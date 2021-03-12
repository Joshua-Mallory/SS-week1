package com.ss.mar.day4.singletonTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.ss.mar.day4.singleton.SingletonC;

public class SingletonTest {
	Runnable thread1, thread2;
	SingletonC sc = SingletonC.getInstance();

	@Test
	public void SingleTonCTest() {
		assertNotNull(SingletonC.test);
		assertNotNull(sc);
	}

}
