/**
 * 
 */
package com.ss.mar.day4.deadlock;

/**
 * @author jcmal
 *
 */
public class Deadlock {

	private Integer obj1, obj2, obj3;
	static Runnable thread1;
	static Runnable thread2;
	static Runnable thread3;

	public Deadlock(Integer obj1, Integer obj2, Integer obj3, Runnable thread1, Runnable thread2, Runnable thread3) {
		this.obj1 = obj1;
		this.obj2 = obj2;
		this.obj3 = obj3;
		Deadlock.thread1 = thread1;
		Deadlock.thread2 = thread2;
		Deadlock.thread3 = thread3;
	}

	public boolean setup() {
		wrap(obj1, obj2, obj3);
		return true;
	}

	public static boolean wrap(Integer obj1, Integer obj2, Integer obj3) {
		thread1 = new Runnable() {
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

		thread2 = new Runnable() {
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
		thread3 = new Runnable() {
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
		FinishLine(thread1, thread2, thread3);
		return true;
	}

	public static boolean FinishLine(Runnable thread1, Runnable thread2, Runnable thread3) {
		System.out.println("Start Program");
		// just to try and get test case coverage...
		thread1.run();
		thread2.run();
		thread3.run();
		new Thread(thread1).start();
		new Thread(thread2).start();
		new Thread(thread3).start();
		System.out.println("Program is locked out, I ran .runs() before threads for something.");
		System.out.println("End Program");
		return true;

	}
}
