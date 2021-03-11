/**
 * 
 */
package com.ss.mar.day3.append;

/**
 * @author jcmal
 *
 */
public class AppendDriver {

	/**
	 * @param args no command line arguments are used. all input is given via
	 *             scanner as prompted. file path must be relative or absolute path
	 */
	public static void main(String[] args) {
		FileAppend fa = new FileAppend();
		try {
			fa.Setup();
		} catch (Exception e) {
			System.out.println("You do not have permission to access this file or something went wrong.");
		}
	}

}
