/**
 * 
 */
package com.ss.mar.day2.area;

/**
 * @author jcmal
 *
 */
public class Triangle implements Shape {
	// calculate area
	@Override
	public void calculateArea() {
		double area;
		double base = 6.5, height = 3.9;
		area = (base * height) / 2;
		display(area);
	}

	// print area
	@Override
	public void display(double area) {
		System.out.println("The area of the triangle is " + area + ".");

	}

}
