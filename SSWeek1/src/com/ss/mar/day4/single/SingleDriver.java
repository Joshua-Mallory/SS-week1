/**
 * 
 */
package com.ss.mar.day4.single;

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
		SingletonC sc2 = SingletonC.getInstance();
		System.out.println(sc2.test);
	}

}
