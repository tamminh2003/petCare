package test.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {
	public static void main (String[] args) {
//		LocalDate temp = LocalDate.parse("2023-04-15");
//		LocalDate temp = LocalDate.now();
		LocalDate temp = LocalDate.parse("2023-12-04", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println(temp.toString());
		System.out.println(temp.getDayOfWeek().toString());
	}
}
