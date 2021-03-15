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

	public static void main(String[] args) {
		RemoveX rm = new RemoveX();
		rm.removeX();
	}

	// removes all x from selct string, impements functional interface
	public static String removal(String temp1) {
		if (temp1 != null) {
			RemoveXFunction lf = temp2 -> temp2.replaceAll("x", "");
			return lf.calculate(temp1);
		} else
			return null;
	}

	// begins stream to perform operations on
	public List<String> removeX() {
		List<String> myStr = Arrays.asList("jotxxe", "axpe", "Davidian", "Axrt", "floundEr", "hoxrse", "apple", "ask",
				"asp", "Axnt");
		List<String> noX = myStr.stream().map(temp1 -> removal(temp1)).collect(Collectors.toList());
		noX.forEach(System.out::println);
		return noX;
	}

}
