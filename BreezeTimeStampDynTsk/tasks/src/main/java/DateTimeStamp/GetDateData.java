package DateTimeStamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.json.*;

public class GetDateData {

	public String BuildTimeData(String Timezone) {

	
        String[] monthName = 
  	  		   {"January", "February", "March", "April", "May", "June", "July",
		        "August", "September", "October", "November", "December"};	  		
        /* Get Day Name */
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); 

        /* Set Formated Dates and Time */
        String strAMPM = "a";        
        SimpleDateFormat am_pm = new SimpleDateFormat(strAMPM);         
        SimpleDateFormat fulldate = new SimpleDateFormat("E-yyyy-MM-dd HH:mm:ss.SSS");

        fulldate.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
        Calendar nowzone = Calendar.getInstance();
        TimeZone timeZone = nowzone.getTimeZone();
        Date now = new Date();

        
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH) + 1 ;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);
   	    int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
    	int hours = cal.get(Calendar.HOUR_OF_DAY);
    	int minutes = cal.get(Calendar.MINUTE);
    	int seconds = cal.get(Calendar.SECOND);   	    
    	int miliseconds = cal.get(Calendar.MILLISECOND);     	
  	
	    JSONObject obj = new JSONObject();	            
		DateTimeData myDateTime;
		myDateTime = new DateTimeData();

		myDateTime.DayOfWeekNo = dayofweek;
		myDateTime.DayOfWeekName = simpleDateformat.format(now);
		myDateTime.DayOfMonthNo = day;
		myDateTime.MonthName = monthName[cal.get(Calendar.MONTH)];
		myDateTime.MonthNo = month;
		myDateTime.YearNo = year;
		myDateTime.HourNo = hours;
		myDateTime.MinuteNo = minutes;
		myDateTime.SecondsNo = seconds;
		myDateTime.MicroSecondsNo =  miliseconds;
		myDateTime.AMPM = am_pm.format(now);
		myDateTime.FullDate = fulldate.format(now);
		myDateTime.TimeZone = timeZone.getDisplayName();
		myDateTime.DateStatus = "ok";		
	
	    try {
			obj.put("dayofweek", myDateTime.DayOfWeekNo);
		    obj.put("dayofweekName", myDateTime.DayOfWeekName);
		    obj.put("day", myDateTime.DayOfMonthNo);
		    obj.put("month", myDateTime.MonthNo);
		    obj.put("monthName", myDateTime.MonthName);
		    obj.put("year", myDateTime.YearNo);
		    obj.put("hours", myDateTime.HourNo);
		    obj.put("minutes", myDateTime.MinuteNo);
		    obj.put("seconds", myDateTime.SecondsNo);
		    obj.put("millis", myDateTime.MicroSecondsNo);
		    obj.put("ampm", myDateTime.AMPM);
		    obj.put("fulldate", myDateTime.FullDate);
		    obj.put("timezone", myDateTime.TimeZone);
		    obj.put("status", myDateTime.DateStatus);	     
		    
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
	    return obj.toString();
		}
}
