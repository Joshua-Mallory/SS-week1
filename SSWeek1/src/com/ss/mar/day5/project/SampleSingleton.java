/**
 * 
 */
package com.ss.mar.day5.project;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SampleSingleton {
	private static Connection conn = null;
	private static SampleSingleton instance = null;

	public static SampleSingleton getInstance() {
		if (instance == null) {
			synchronized (SampleSingleton.class) {
				if (instance == null)
					instance = new SampleSingleton();
			}
		}
		return instance;
	}

	public static void databaseQuery(BigDecimal input) {

		try {
			conn = DriverManager.getConnection("url of database");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select id from table");
			BigDecimal x = new BigDecimal(0);
			while (rs.next()) {
				x = rs.getBigDecimal(1).multiply(input);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Some Error has occured");
			e.printStackTrace();
		}

	}
}