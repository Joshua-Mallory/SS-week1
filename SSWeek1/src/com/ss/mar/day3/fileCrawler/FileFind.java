/**
 * 
 */
package com.ss.mar.day3.fileCrawler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author jcmal
 *
 */
public class FileFind {
	/*
	 * accepts the path file, walks the directory and outputs all files and
	 * sub-directories
	 * 
	 */
	public void PathFinder(String args2[]) {
		File index = new File(args2[0]);
		Stream<Path> walk = null;
		try {
			walk = Files.walk(index.toPath()); // no level depth is stated so default is max
		} catch (IOException e) {
			System.out.println("Some error has occured. Most likely an invalid path has been supplied");
		}
		walk.forEach(System.out::println);
	}

}
