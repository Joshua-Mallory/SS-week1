/**
 * 
 */
package com.ss.mar.day5.timeAPI;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Vector;

/**
 * @author jcmal
 *
 */
public class DateTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// birthDay();
		// lastThurs();
		// instant();
		// monthLength();
		// monthMonday();
		friday();
	}

	public void birthDay() {
		LocalDateTime birth = LocalDateTime.of(1995, 02, 26, 15, 37, 46, 123456789);
	};

	public static void lastThurs() {
		Vector<String> dayVec = new Vector<>();
		dayVec.add("THURSDAY");
		dayVec.add("FRIDAY");
		dayVec.add("SATURDAY");
		dayVec.add("SUNDAY");
		dayVec.add("MONDAY");
		dayVec.add("TUESDAY");
		dayVec.add("WEDNESDAY");
		LocalDate df = LocalDate.of(1995, 02, 24);
		String day = df.getDayOfWeek().toString();
		int diff = dayVec.indexOf(day, 0);
		if (diff == 0) {
			diff = 7;
		}
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_YEAR, df.getDayOfYear() - diff);
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
		System.out.println(sdf.format(cal.getTime()));
	};

	public static void instant() {
		ZonedDateTime zone = ZonedDateTime.now();
		// System.out.println(zone.toString());
		Instant here = Instant.now();
		// System.out.println(here);
		Instant conv = zone.toInstant();
		ZonedDateTime conv2 = zone.ofInstant(here, ZoneId.systemDefault());
		System.out.println(conv.toString());
		System.out.println(conv2.toString());
	}

	public static void monthLength() {
		for (int month = 1; month <= 12; month++) {
			YearMonth yearMonth = YearMonth.of(2020, month);
			System.out.println(yearMonth.lengthOfMonth());
		}
	}

	public static void monthMonday() {

		LocalDate df = LocalDate.of(1995, 02, 1);
		String day = df.getDayOfWeek().toString();
		YearMonth yearMonth = YearMonth.of(1995, 02);
		for (int i = 1; i <= yearMonth.lengthOfMonth(); i++) {
			DayOfWeek day2 = yearMonth.atDay(i).getDayOfWeek();
			if (day2.equals(DayOfWeek.MONDAY)) {
				System.out.println(day2.toString());
				System.out.println(i);
			}
		}
	}

	public static void friday() {
		// 7. Write an example that tests whether a given date occurs on Friday the
		// 13th.

	}
}
