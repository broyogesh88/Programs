package sorting;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Example {
   public static void main(String[] args) 
   {
	Date date = new Date();
	System.out.println(date);
	SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy");
	String dates = formatter.format(date);
	dates += " 17:00:00";
	formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	
    try {
		Date newDate = (Date) formatter.parse(dates);
		long timeMilli = date.getTime();
		System.out.println(timeMilli);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
   }
}
