/**
 * 
 */
package com.ss.mar.day4.deadlock;

/**
 * @author jcmal
 *
 */
public class Deadlock {

	/**
	 * @param args
	 */

	public void setup() {
		Integer obj1 = 1;
		Integer obj2 = 2;
		Integer obj3 = 3;
		wrap(obj1, obj2, obj3);
	}

	public static void wrap(Integer obj1, Integer obj2, Integer obj3) {
		Runnable t1 = new Runnable() {

			@Override
			public void run() {
				try {
					synchronized (obj1) {
						Thread.sleep(100);
						// System.out.println("Thread 1 in first lock");
						synchronized (obj2) {
							System.out.println("Thread 1 got both locks");
						}
					}
				} catch (Exception e) {
				}
			}
		};

		Runnable t2 = new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (obj2) {
						Thread.sleep(100);
						// System.out.println("Thread 2 in first lock");
						synchronized (obj3) {
							System.out.println("Thread 2 got both locks");
						}
					}
				} catch (Exception e) {
				}
			}
		};
		Runnable t3 = new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (obj3) {
						Thread.sleep(100);
						// System.out.println("Thread 3 in first lock");
						synchronized (obj1) {
							System.out.println("Thread 3 got both locks");
						}
					}
				} catch (Exception e) {
				}
			}
		};
		FinishLine(t1, t2, t3);
	}

	public static void FinishLine(Runnable thread1, Runnable thread2, Runnable thread3) {
		System.out.println("Start Program");
		new Thread(thread1).start();
		new Thread(thread2).start();
		new Thread(thread3).start();
		System.out.println("End Program");

	}
}
