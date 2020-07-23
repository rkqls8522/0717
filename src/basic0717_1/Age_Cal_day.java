
package basic0717_1;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Age_Cal_day {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
	
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String today = year+"-"+month+"-"+day;
	
		String date = "2001-09-28";
		
		try{ 
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date TodayDate = format.parse(today);
			Date FirstDate = format.parse(date);
			
			long calDate =TodayDate.getTime()-  FirstDate.getTime(); 
			long calDateDays = calDate / ( 24*60*60*1000);
			
			System.out.println("출생일로부터 만 "+calDateDays+"일 째입니다.");
		}
		catch(ParseException e)
		{
			// 예외 처리
		}
	
	}
}
