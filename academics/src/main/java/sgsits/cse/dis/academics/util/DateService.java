package sgsits.cse.dis.academics.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DateService {

	public boolean isDateInCurrentWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		int year = cal.get(Calendar.YEAR);
		Calendar targetcal = Calendar.getInstance();
		targetcal.setTime(date);
		int targetWeek = targetcal.get(Calendar.WEEK_OF_YEAR);
		int targetYear = targetcal.get(Calendar.YEAR);
		return week == targetWeek && year == targetYear;
	}

	public List<String> getCurrentWeekDates() {
		Calendar c = Calendar.getInstance();
		List<String> output =  new ArrayList<String>();
		
		// Get current Day of week and Apply suitable offset to bring the new calendar
		// back to the appropriate Monday, i.e. this week or next
		switch (c.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.SUNDAY:
			c.add(Calendar.DATE, 1);
			break;

		case Calendar.MONDAY:
			// Don't need to do anything on a Monday
			// included only for completeness
			break;

		case Calendar.TUESDAY:
			c.add(Calendar.DATE, -1);
			break;

		case Calendar.WEDNESDAY:
			c.add(Calendar.DATE, -2);
			break;

		case Calendar.THURSDAY:
			c.add(Calendar.DATE, -3);
			break;

		case Calendar.FRIDAY:
			c.add(Calendar.DATE, -4);
			break;

		case Calendar.SATURDAY:
			c.add(Calendar.DATE, 2);
			break;
		}

		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		// Add the Monday to the output
		//String date = simpleDateFormat.format(c.getTime());
		output.add(simpleDateFormat.format(c.getTime()));
		for (int x = 1; x < 5; x++) {
			// Add the remaining days to the output
			c.add(Calendar.DATE, 1);
			output.add(simpleDateFormat.format(c.getTime()));
		}
		return output;
	}

}
