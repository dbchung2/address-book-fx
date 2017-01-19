package ch.makery.address.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarUtil {
	// set the format of the date 
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	// format the calendar to date format
	public static String format(Calendar calendar){
		if (calendar == null) return null;
		return DATE_FORMAT.format(calendar.getTime());
	}
	
	public static Calendar parse(String date){
		
		Calendar calendar = Calendar.getInstance();
		try{
			
			calendar.setTime(DATE_FORMAT.parse(date));
			return calendar;
			
		}catch(ParseException  e){
			
			return null;
		}
	}
	
	public static boolean validString(String date){
		
		try{
			DATE_FORMAT.parse(date);
			return true;
		}catch(ParseException e){
		return false;
		}
	}
	
}
