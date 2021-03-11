/**
 * 
 */
package com.ss.mar.day3.append;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author jcmal
 *
 */
public class FileAppend {
	/*
	 * opens or creates a file for appending. appends to a newline. requires file
	 * input to be a relative or absolute path
	 */
	public void Setup() throws Exception {
		FileWriter fileWriter = null;
		Scanner sc = new Scanner(System.in);
		BufferedWriter buff = null;
		PrintWriter printer = null;
		System.out.println("What file would you like to append or create and append?");
		String name = sc.nextLine();
		fileWriter = new FileWriter(name, true);
		buff = new BufferedWriter(fileWriter);
		printer = new PrintWriter(buff);
		System.out.println("What would you like to append to this file?");
		String appendData = sc.nextLine();
		printer.println(appendData);
		printer.close();
		buff.close();
		fileWriter.close();
		sc.close();
	}
}
