/**
 * 
 */
package com.ss.mar.day4.singleton;

/**
 * @author jcmal
 *
 */
public class SingleDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingletonC sc = SingletonC.getInstance();
		System.out.println(sc.test);
	}

}
