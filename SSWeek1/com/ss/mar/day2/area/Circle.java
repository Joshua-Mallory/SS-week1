/**
 * 
 */
package com.ss.marday2.area;

/**
 * @author jcmal
 *
 */
public class Circle implements Shape {

	@Override
	public void calculateArea() {
		double area;
		double radius = 5.5;
		area = Math.PI * (radius * radius);
		display(area);
	}

	@Override
	public void display(double area) {
		System.out.println("The area of the circle is " + area + ".");

	}

}
