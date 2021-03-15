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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * @author jcmal
 *
 */
public class DateTime {

	// performs many operations related to date time
	public static void main(String[] args) {
		DateTime dt = new DateTime();
		LocalDateTime birth = LocalDateTime.of(1995, 02, 26, 15, 37, 46, 123456789);
		dt.birthDay(birth);
		LocalDate df = LocalDate.of(1995, 02, 24);
		dt.lastThurs(df);
		dt.zoneId();
		dt.instant();
		Integer year = 2019;
		dt.monthLength(year);
		YearMonth yearMonth = YearMonth.of(1995, 02);
		dt.monthMonday(yearMonth);
		LocalDate df2 = LocalDate.of(2020, 3, 13);
		dt.friday(df2);
	}

	// Store Birthday
	public LocalDateTime birthDay(LocalDateTime birth) {
		System.out.println("Stored Birthday");
		if (birth != null) {
			System.out.println(birth.toString());
			return birth;
		} else {
			System.out.println("No Birthday Given");
			return null;
		}
	};

	// Find date of previous Thursday
	public String lastThurs(LocalDate df) {
		if (df != null) {
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
			return sdf.format(cal.getTime());
		} else {
			System.out.println("No date was passed");
			return null;
		}
	};

	// difference between zoneID and ZoneOffset
	public String[] zoneId() {
		LocalDateTime now = LocalDateTime.now();
		// ZoneId returns the location
		List<String> zoneList = ZoneId.getAvailableZoneIds().stream().collect(Collectors.toList());
		// zoneList.forEach(System.out::println);
		System.out.println("Zone ID and ZoneOffset");
		System.out.println(zoneList.get(0).toString());
		// ZoneOffSet is showing the offset of time from Greenwhich
		ZoneOffset zoneOff = ZoneId.of(zoneList.get(0)).getRules().getOffset(now);
		System.out.println(zoneOff.toString());
		String[] forOut = { zoneList.get(0).toString(), zoneOff.toString() };
		return forOut;
	}

	// Instant to ZonedDateTime and ZonedDateTime to Instant
	public String[] instant() {

		ZonedDateTime zone = ZonedDateTime.now();
		Instant conv2Instant = zone.toInstant();
		ZonedDateTime conv2Zoned = zone.ofInstant(conv2Instant, ZoneId.systemDefault());
		Instant convBack = conv2Zoned.toInstant();
		Instant here = Instant.now();
		System.out.println("Convert instant to zoned and zoned to instant");
		System.out.println(conv2Zoned.toString());
		System.out.println(conv2Instant.toString());
		String[] forOut = { conv2Zoned.toString(), zone.toString(), conv2Instant.toString(), convBack.toString() };
		return forOut;
	}

	// find the length of months of given a year
	public List<Integer> monthLength(Integer year) {
		if (year != null) {
			System.out.println("Length of Months in a given year");
			List<Integer> days = new ArrayList<Integer>();
			for (int month = 1; month <= 12; month++) {
				YearMonth yearMonth = YearMonth.of(year, month);
				days.add(yearMonth.lengthOfMonth());
				System.out.println(yearMonth.getYear() + " " + yearMonth.getMonth() + " " + yearMonth.lengthOfMonth());
			}
			return days;
		} else {
			System.out.println("No year was given");
			return null;
		}
	}

	// find how many Mondays
	public List<String> monthMonday(YearMonth yearMonth) {
		if (yearMonth != null) {
			System.out.println("All Mondays in a given month in a given year.");
			List<String> mondays = new ArrayList<String>();
			for (int i = 1; i <= yearMonth.lengthOfMonth(); i++) {
				DayOfWeek day2 = yearMonth.atDay(i).getDayOfWeek();
				if (day2.equals(DayOfWeek.MONDAY)) {
					LocalDate df = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), i);
					System.out.println(df.toString());
					mondays.add(df.toString());
				}
			}
			return mondays;
		} else {
			return null;
		}
	}

	// find if friday the 13th
	public boolean friday(LocalDate df) {
		if (df != null) {
			System.out.println("If a given day is a friday the 13.");
			DayOfWeek day2 = df.getDayOfWeek();
			if (day2.equals(DayOfWeek.FRIDAY)) {
				System.out.println(df.toString() + " is Friday the 13.");
				return true;
			} else {
				System.out.println(df.toString() + " is not Friday the 13.");
				return false;
			}
		} else {
			System.out.println("Invalid date or no date given.");
			return false;
		}
	}
}
