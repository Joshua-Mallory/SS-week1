/**
 * 
 */
package com.ss.mar.day2.area;

/**
 * @author jcmal
 *
 */
public class AreaCalc {

	/**
	 * @param args
	 */
	// creates instances of and calls functions necessary to calculate and print
	// areas
	public static void main(String[] args) {
		Rectangle rect = new Rectangle();
		Circle cir = new Circle();
		Triangle tri = new Triangle();
		rect.calculateArea();
		cir.calculateArea();
		tri.calculateArea();
	}
}
