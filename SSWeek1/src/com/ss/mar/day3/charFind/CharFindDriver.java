/**
 * 
 */
package com.ss.mar.day3.charFind;

/**
 * @author jcmal
 *
 */
public class CharFindDriver {

	/**
	 * @param args this program accepts via command line a char to find occurrences
	 *             of and an absolute or relative path to file
	 * @throws Exception
	 */
	public static void main(String[] args) {
		CharFind cf = new CharFind();
		try {
			cf.charLocate(args);
		} catch (Exception e) {
			System.out.println("Some error has occured, most likely command line args are malformed.");
		}
	}

}
