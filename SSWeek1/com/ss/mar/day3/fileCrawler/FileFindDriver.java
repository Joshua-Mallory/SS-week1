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
		try {
			ff.PathFinder(args);
		} catch (Exception e) {
			System.out.println("Some error has occured. Most likely an invalid path has been supplied");
		}
	}

}
