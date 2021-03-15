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
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * @author jcmal
 *
 */
public class DateTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LocalDateTime birth = LocalDateTime.of(1995, 02, 26, 15, 37, 46, 123456789);
		birthDay(birth);
		LocalDate df = LocalDate.of(1995, 02, 24);
		lastThurs(df);
		zoneId();
		instant();
		Integer year = 2019;
		monthLength(year);
		YearMonth yearMonth = YearMonth.of(1995, 02);
		monthMonday(yearMonth);
		LocalDate df2 = LocalDate.of(2020, 3, 13);
		friday(df2);
	}

	// Store Birthday
	public static void birthDay(LocalDateTime birth) {
		System.out.println("Stored Birthday");
		System.out.println(birth.toString());
	};

	// Find date of previous Thursday
	public static void lastThurs(LocalDate df) {
		Vector<String> dayVec = new Vector<>();
		dayVec.add("THURSDAY");
		dayVec.add("FRIDAY");
		dayVec.add("SATURDAY");
		dayVec.add("SUNDAY");
		dayVec.add("MONDAY");
		dayVec.add("TUESDAY");
		dayVec.add("WEDNESDAY");
		String day = df.getDayOfWeek().toString();
		int diff = dayVec.indexOf(day, 0);
		if (diff == 0) {
			diff = 7;
		}
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_YEAR, df.getDayOfYear() - diff);
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
		System.out.println("Date of last Thursday");
		System.out.println(sdf.format(cal.getTime()));
	};

	// difference between zoneID and ZoneOffset
	public static void zoneId() {
		LocalDateTime now = LocalDateTime.now();
		// ZoneId returns the location
		List<String> zoneList = ZoneId.getAvailableZoneIds().stream().collect(Collectors.toList());
		// zoneList.forEach(System.out::println);
		System.out.println("Zone ID and ZoneOffset");
		System.out.println(zoneList.get(0).toString());
		// ZoneOffSet is showing the offset of time from Greenwhich
		ZoneOffset zoneOff = ZoneId.of(zoneList.get(0)).getRules().getOffset(now);
		System.out.println(zoneOff.toString());
	}

	// Instant to ZonedDateTime and ZonedDateTime to Instant
	public static void instant() {
		ZonedDateTime zone = ZonedDateTime.now();
		Instant here = Instant.now();
		Instant conv2Instant = zone.toInstant();
		ZonedDateTime conv2Zoned = zone.ofInstant(here, ZoneId.systemDefault());
		System.out.println("Convert instant to zoned and zoned to instant");
		System.out.println(conv2Zoned.toString());
		System.out.println(conv2Instant.toString());
	}

	// find the length of months of given a year
	public static void monthLength(Integer year) {
		System.out.println("Length of Months in a given year");
		for (int month = 1; month <= 12; month++) {
			YearMonth yearMonth = YearMonth.of(year, month);
			System.out.println(yearMonth.getYear() + " " + yearMonth.getMonth() + " " + yearMonth.lengthOfMonth());
		}
	}

	// find how many Mondays
	public static void monthMonday(YearMonth yearMonth) {
		System.out.println("All Mondays in a given month in a given year.");

		for (int i = 1; i <= yearMonth.lengthOfMonth(); i++) {
			DayOfWeek day2 = yearMonth.atDay(i).getDayOfWeek();
			if (day2.equals(DayOfWeek.MONDAY)) {
				LocalDate df = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), i);
				System.out.println(df.toString());
			}
		}
	}

	// find if friday the 13th
	public static void friday(LocalDate df) {
		System.out.println("If a given day is a friday the 13.");

		DayOfWeek day2 = df.getDayOfWeek();
		if (day2.equals(DayOfWeek.FRIDAY)) {
			System.out.println(df.toString() + " is Friday the 13.");
		}

	}
}
