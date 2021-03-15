/**
 * 
 */
package com.ss.mar.day5.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jcmal
 *
 */
public class LambdaReader {
	public boolean reader(FileReader fileLoc) {
		try {
			BufferedReader br = null;
			br = new BufferedReader(fileLoc);
			String line = br.readLine();
			Lambdas lam = new Lambdas();
			Integer testCases = Integer.parseInt(line);
			List<Integer> cases = new ArrayList<Integer>();
			List<Integer> values = new ArrayList<Integer>();

			for (int i = 0; i < testCases; i++) {
				try {
					line = br.readLine();
					String[] parAndArg = line.split(" ");
					cases.add(Integer.parseInt(parAndArg[0]));
					values.add(Integer.parseInt(parAndArg[1]));
				} catch (Exception e) {
					System.out.println("Test case number does not match file contents.");
				}

			}
			lam.lambdaWalk(cases, values);
			br.close();
		} catch (Exception e) {
			System.out.println("Invalid File or contents");
			return false;
		}
		return true;

	}
}
