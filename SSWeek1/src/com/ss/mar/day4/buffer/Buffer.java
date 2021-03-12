package com.ss.mar.day4.buffer;

import java.util.concurrent.ArrayBlockingQueue;

//buffer with size determined by arrayBlock prints 100 attempts at random pulls or pushes
public class Buffer {

	static Runnable thread1;
	static Runnable thread2;

	public Buffer(Runnable thread1, Runnable thread2) {
		Buffer.thread1 = thread1;
		Buffer.thread2 = thread2;
	}

	public boolean wrap() {
		// FIFO bounded object
		ArrayBlockingQueue<Integer> arrayBlock = new ArrayBlockingQueue<Integer>(8);

		Runnable thread1 = new Runnable() {

			@Override
			public void run() {
				try {
					synchronized (arrayBlock) {
						// Thread.sleep(100);
						arrayBlock.add(5);
						System.out.println("Producer Push");
					}
				} catch (Exception e) {
					System.out.println("Buffer is Full, Producer could not pull an Item.");
				}
			}
		};

		Runnable thread2 = new Runnable() {

			@Override
			public void run() {
				try {
					synchronized (arrayBlock) {
						// Thread.sleep(100);
						arrayBlock.remove();
						System.out.println("Consumer Pull");
					}
				} catch (Exception e) {
					System.out.println("Buffer is empty, Consumer could not pull an Item.");
				}
			}
		};
		ThreadRun(thread1, thread2);
		return true;
	}

	public boolean ThreadRun(Runnable thread1, Runnable thread2) {
		System.out.println("Start Program");
		int counter = 0;
		thread1.run();
		thread2.run();
		while (counter != 100) {

			new Thread(thread1).start();
			new Thread(thread2).start();
			counter++;
		}
		return true;

	}
}
