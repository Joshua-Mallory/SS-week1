package com.ss.mar.day5.project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileReader;

import org.junit.Test;

public class LambdaReaderTest {

	LambdaReader lr = new LambdaReader();

	@Test
	public void readerTest() {
		assertFalse(lr.reader(null));
		FileReader fileLoc = null;
		FileReader fileLoc2 = null;
		try {
			fileLoc = new FileReader("testLambda.txt");
			fileLoc2 = new FileReader("testLambd.txt");
		} catch (Exception e) {
			System.out.print("Bad File Path");
		}
		assertTrue(lr.reader(fileLoc));
		assertFalse(lr.reader(fileLoc2));
	}

}
