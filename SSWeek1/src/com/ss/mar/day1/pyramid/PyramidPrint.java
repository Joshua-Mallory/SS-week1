/**
 * 
 */
package com.ss.mar.day1.pyramid;

/**
 * @author jcmal
 *
 */
/*
 * creates and prints all pyramids
 */
public class PyramidPrint {

	/**
	 *calls functions for each pyramid and passes iterations and period number
	 */
	public void printer() {
		leftJust(4,9);
		leftDown(4,10);
		centerJust(4,11);
		centerDown(4,12);
	}
	//left justified regular
	public void leftJust(int num,int period) {
		System.out.println("1)");
		for (int i=0;i<num;i++) { 
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		periodPrint(period);
	}
	//left justified down
	public void leftDown(int num,int period) {
		System.out.println("2)");
		periodPrint(period);
		for (int i=0;i<num;i++) { 
			for(int j=num;j>i;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	//middle justified over period number with uneven distribution excess to the right when needed
	public void centerJust(int num,int period) {
		System.out.println("3)");
		num=num*2;
		for (int i=0,k=0;i<num;i=i+2,k++) { 
			int spacer=(period-1)/2-k;
			for (int j=0;j<spacer;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++) {
					System.out.print("*");
			}
			System.out.println();
		}
		periodPrint(period);
	}
	//middle justified down over period number with uneven distribution excess to the right when needed
	public void centerDown(int num,int period) {
		System.out.println("4)");
		periodPrint(period);
		num=num*2;
		for (int i=0,k=num;i<num;i=i+2,k=k-2) { 
			int spacer=(period-k+1)/2;
			for (int j=0;j<spacer;j++) {
				System.out.print(" ");
			}
			for(int j=num-1;j>i;j--) {
					System.out.print("*");
			}
			System.out.println();
		}	
	}
	//prints period line
	public void periodPrint(int num) {
		for (int i=0;i<num;i++)
			System.out.print('.');
		System.out.println();
	}
	
}
