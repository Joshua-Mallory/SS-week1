package com.ss.mar.day4.buffer;

public class BufferDriver {
	// runs with preset conditions creates a fifo buffer. ending a thread if it
	// cant execute
	public static void main(String[] args) {
		Runnable thread1 = null;
		Runnable thread2 = null;
		Buffer b = new Buffer(thread1, thread2);
		b.wrap();
	}

}
