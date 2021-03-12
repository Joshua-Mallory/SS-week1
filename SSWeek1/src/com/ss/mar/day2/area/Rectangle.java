/**
 * 
 */
package com.ss.mar.day2.area;

/**
 * @author jcmal
 *
 */
public class Rectangle implements Shape {
	// calculate area
	@Override
	public void calculateArea() {
		double area;
		double length = 5.5, width = 8.9;
		area = length * width;
		display(area);
	}

	// print area
	@Override
	public void display(double area) {
		System.out.println("The area of the rectangle is " + area + ".");

	}

}
