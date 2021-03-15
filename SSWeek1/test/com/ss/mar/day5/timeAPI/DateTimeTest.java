package com.ss.mar.day5.timeAPI;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DateTimeTest {
	DateTime dt = new DateTime();

	@Test
	public void birthDayTest() {
		assertTrue((dt.birthDay(LocalDateTime.of(1995, 02, 26, 15, 37, 46, 123456789)).toString())
				.equals("1995-02-26T15:37:46.123456789"));
		assertFalse((dt.birthDay(LocalDateTime.of(1996, 02, 26, 15, 37, 46, 123456789)).toString())
				.equals("1995-02-26T15:37:46.123456789"));
		assertNull(dt.birthDay(null));
	}

	@Test
	public void lastThursTest() {
		LocalDate df = LocalDate.of(1995, 02, 24);
		assertTrue(dt.lastThurs(df).equals("2021/02/23"));
		assertFalse(dt.lastThurs(df).equals("2021/02/22"));
		assertNull(dt.lastThurs(null));
		assertTrue(dt.lastThurs(LocalDate.of(1995, 02, 23)).equals("2021/02/16"));
	}

	@Test
	public void zoneIdTest() {
		String[] arr = dt.zoneId();
		assertTrue(arr[0].equals("Asia/Aden"));
		assertFalse(arr[0].equals("Europe"));
		assertTrue(arr[1].equals("+03:00"));
		assertFalse(arr[1].equals("+02:00"));
	}

	@Test
	public void instantTest() {
		String[] arr = dt.instant();
		System.out.println(arr[0] + "\n" + arr[1]);
		assertTrue(arr[0].equals(arr[1]));
		assertFalse(arr[0].equals(arr[2]));
		assertTrue(arr[2].equals(arr[3]));
		assertFalse(arr[2].equals(arr[1]));
	}

	@Test
	public void monthLengthTest() {
		Integer year = 2019;
		List<Integer> expected = Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
		assertArrayEquals(expected.toArray(), dt.monthLength(year).toArray());
		assertNull(dt.monthLength(null));
	}

	@Test
	public void monthMondayTest() {
		YearMonth yearMonth = YearMonth.of(1995, 02);
		List<String> expected = Arrays.asList("1995-02-06", "1995-02-13", "1995-02-20", "1995-02-27");
		assertArrayEquals(expected.toArray(), dt.monthMonday(yearMonth).toArray());
		assertNull(dt.monthMonday(null));
	}

	@Test
	public void fridayTest() {
		assertTrue(dt.friday(LocalDate.of(2020, 3, 13)));
		assertFalse(dt.friday(LocalDate.of(2020, 4, 13)));
		assertFalse(dt.friday(null));
	}

}
