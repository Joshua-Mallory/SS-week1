/**
 * 
 */
package com.ss.mar.day4.deadlock;

/**
 * @author jcmal
 *
 */
public class DeadlockDriver {
	public static void main(String[] args) {
		Runnable thread1 = null;
		Runnable thread2 = null;
		Runnable thread3 = null;

		Deadlock d = new Deadlock(1, 2, 3, thread1, thread2, thread3);
		d.setup();
	}
}
