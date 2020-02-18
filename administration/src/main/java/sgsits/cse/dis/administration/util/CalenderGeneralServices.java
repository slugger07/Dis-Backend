package sgsits.cse.dis.administration.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
/**
 * <h1><b>CalenderGeneralServices</b> class.</h1>
 * <p>This class contains implementation of all the general purpose calendar related services.
 * 
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 2-DEC-2019.
 * @throws ParseException.
 * @see ParseException.
 */
public class CalenderGeneralServices {

	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
				
		return cal.getTime();
	}
	
	public static Date subtractDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -days);
				
		return cal.getTime();
	}
	
	public static long getDaysBetweenDates(String date1,String date2) throws ParseException {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		long diff = myFormat.parse(date2).getTime() - myFormat.parse(date1).getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
}
