/**
 * 
 */
package com.ss.mar.day3.fileCrawler;

/**
 * @author jcmal
 *
 */
public class FileFindDriver {

	/**
	 * @param args. absolute path to a file is given as command line arg
	 *
	 */
	public static void main(String[] args) {
		FileFind ff = new FileFind();
		ff.PathFinder(args);
	}

}
