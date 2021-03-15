/**
 * 
 */
package com.ss.mar.day5.project;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jcmal
 *
 */
public class RemoveX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> myStr = Arrays.asList("jotxxe", "axpe", "Davidian", "Axrt", "floundEr", "hoxrse", "apple", "ask",
				"asp", "Axnt");
		removeX(myStr);
	}

	public static String removal(String temp1) {
		return temp1.replaceAll("x", "");
	}

	public static void removeX(List<String> myStr) {
		List<String> noX = myStr.stream().map(temp1 -> removal(temp1)).collect(Collectors.toList());
		noX.forEach(System.out::println);
	}

}
