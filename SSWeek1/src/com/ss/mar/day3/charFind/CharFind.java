/**
 * 
 */
package com.ss.mar.day3.charFind;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author jcmal
 *
 */
public class CharFind {
	// reads a file line by line checking for the given character
	public void charLocate(String[] args2) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader(args2[1]));
		String line;
		Integer count = 0;
		while ((line = br.readLine()) != null) {
			count = count + line.length() - line.replaceAll(args2[0], "").length();
		}
		System.out.println(count);
		br.close();
	}
}
