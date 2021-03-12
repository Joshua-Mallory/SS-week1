/**
 * 
 */
package com.ss.mar.day4.singleton;

/**
 * @author jcmal
 *
 */
public class SingletonC {

	volatile public static SingletonC instance = null;
	public static String test = null;

	private SingletonC() {
		test = "Just for fun";
	}

	public static SingletonC getInstance() {
		if (instance == null) {
			synchronized (SingletonC.class) {
				if (instance == null)
					instance = new SingletonC();
			}
		}
		return instance;
	}

}
