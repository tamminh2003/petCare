package main.java.util;

import java.time.*;
import java.util.Arrays;

public class DateTime {
	public static LocalDate getStartOfWeek(LocalDate timeOfWeek) {
		Integer minusDays = 0;
		switch (timeOfWeek.getDayOfWeek()) {
			case TUESDAY:
				minusDays = 1;
				break;
			case WEDNESDAY:
				minusDays = 2;
				break;
			case THURSDAY:
				minusDays = 3;
				break;
			case FRIDAY:
				minusDays = 4;
				break;
			case SATURDAY:
				minusDays = 5;
				break;
			case SUNDAY:
				minusDays = 6;
				break;
			default:
				break;
		}
		return timeOfWeek.minusDays(minusDays);
	}
	
	public static LocalTime[] getTimeslotsTemplate() {
		LocalTime[] timeslotsTemplate = new LocalTime[16];
		Arrays.fill(timeslotsTemplate, LocalTime.now());
		LocalTime openingTime = LocalTime.of(9, 0);
		for(int i = 0; i < timeslotsTemplate.length; i++) {
			timeslotsTemplate[i] = openingTime.plusMinutes(30*i);
		}
		return timeslotsTemplate;
	}
	
	public static LocalDate[] getDatesOfWeek() {
		LocalDate[] datesOfWeek = new LocalDate[7];
		Arrays.fill(datesOfWeek, LocalDate.now());
		LocalDate startOfWeek = getStartOfWeek(LocalDate.now());
		for(int i = 0; i < datesOfWeek.length; i++) {
			datesOfWeek[i] = startOfWeek.plusDays(i);
		}
		return datesOfWeek;
	}
	
	public static LocalDate[] getDatesOfWeek(Integer displayWeek) {
		LocalDate[] datesOfWeek = new LocalDate[7];
		Arrays.fill(datesOfWeek, LocalDate.now());
		LocalDate startOfWeek = getStartOfWeek(LocalDate.now().plusWeeks(displayWeek));
		for(int i = 0; i < datesOfWeek.length; i++) {
			datesOfWeek[i] = startOfWeek.plusDays(i);
		}
		return datesOfWeek;
	}
}
