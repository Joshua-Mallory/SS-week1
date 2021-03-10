/**
 * 
 */
package com.ss.marday2.area;

/**
 * @author jcmal
 *
 */
public class Rectangle implements Shape {

	@Override
	public void calculateArea() {
		double area;
		double length = 5.5, width = 8.9;
		area = length * width;
		display(area);
	}

	@Override
	public void display(double area) {
		System.out.println("The area of the rectangle is " + area + ".");

	}

}
