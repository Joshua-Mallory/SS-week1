/**
 * 
 */
package com.ss.marday2.max;

import java.util.Vector;

/**
 * @author jcmal
 *
 */
public class MaxFinder {
	// sets up 2d number array, current max placeholder
	// and an array for duplicate entries of max to store coordinates
	public void maxRun() {
		int[][] numArray = { { 23, 23, 76, 76 }, { 695, 695, 43, 65 }, { 89, 695, 534, 6 }, { 96, 569, 57, 75 },
				{ 465, 324, 19, 3 } };
		int curMax = numArray[0][0];
		Vector<Integer> cords = new Vector<Integer>();
		maxFind(numArray, curMax, cords);
	}

	// updates current max and keeps track of duplicate maxes
	public void maxFind(int[][] numArray, int curMax, Vector<Integer> cords) {

		for (int i = 0; i < numArray.length; i++) {
			for (int j = 0; j < numArray[i].length; j++) {
				if (numArray[i][j] > curMax) {
					curMax = numArray[i][j];
					cords = new Vector<Integer>();
					cords.add(i);
					cords.add(j);
				} else if (numArray[i][j] == curMax) {
					cords.add(i);
					cords.add(j);
				}
			}
		}
		maxPrint(cords, curMax);
	}

	// prints max value and its position(s)
	public void maxPrint(Vector<Integer> cords, int curMax) {
		System.out.println(cords.elementAt(0) + "," + cords.elementAt(1));
		System.out.print("The maximum value is " + curMax + " at position(s) ");
		for (int i = 0; i < cords.size(); i = i + 2) {
			System.out.print("[" + cords.elementAt(i) + "," + cords.elementAt(i + 1) + "]");
		}
	}
}
