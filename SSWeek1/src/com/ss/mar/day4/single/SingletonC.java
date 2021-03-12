/**
 * 
 */
package com.ss.mar.day4.single;

/**
 * @author jcmal
 *
 */
public class SingletonC {

	volatile public static SingletonC instance = null;
	public String test = null;

	public static SingletonC getInstance() {
		if (instance == null) {
			synchronized (SingletonC.class) {
				if (instance == null)
					instance = new SingletonC();
			}
		}
		return instance;
	}

	private SingletonC() {
		test = "Just for fun";
	}

}
