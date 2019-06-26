package practise;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeZoneConverter {

	public static void convert(int hour, int minutes, String timeZone) {
		System.out.println("------");
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minutes);
		DateFormat sdf = new SimpleDateFormat("HH:mm");
		TimeZone defaultTz = TimeZone.getTimeZone(timeZone);
		System.out.println("Converting the hour and min to timeZone " + defaultTz.getDisplayName());
		sdf.setTimeZone(defaultTz);
		String dateStr = sdf.format(calendar.getTime());
		System.out.println("The hour:min for scheduling is " + dateStr);
		System.out.println("------");

	}

	public static void main(String[] args) {
		int hour = 20;
		int minute = 10;
		String[] timeZone = { "America/Los_Angeles", "America/New_York", "Europe/London", "Asia/Kolkata" };
		for (int i = 0; i < timeZone.length; i++)
			TimeZoneConverter.convert(hour, minute, timeZone[i]);
	}

}
