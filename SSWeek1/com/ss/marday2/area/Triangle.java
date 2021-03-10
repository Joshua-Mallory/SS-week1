/**
 * 
 */
package com.ss.marday2.area;

/**
 * @author jcmal
 *
 */
public class Triangle implements Shape {

	@Override
	public void calculateArea() {
		double area;
		double base = 6.5, height = 3.9;
		area = (base * height) / 2;
		display(area);
	}

	@Override
	public void display(double area) {
		System.out.println("The area of the triangle is " + area + ".");

	}

}
