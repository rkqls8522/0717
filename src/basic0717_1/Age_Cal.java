
package basic0717_1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//<만나이 계산기 만드는 순서>
//1) 오늘 날짜구하기, 출생날짜 구하기
	// +잘못된 입력의 예외 처리
//2) 월별로 일수가 다르니 그에 대한 배열 만들기
//3) 윤년계산하여 예외처리하기
//4) 년, 월, 일별로 숫자 빼기
//5) 음수가 나오지 않게 하고, 디버깅


public class Age_Cal {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		//System.out.println(cal);
		
		//1) 오늘 날짜와 출생날짜 입력
		int today_year = cal.get(Calendar.YEAR);
		int today_month = cal.get(Calendar.MONTH) + 1;
		int today_day = cal.get(Calendar.DAY_OF_MONTH);
		String today_date = today_year +"-"+today_month +"-" + today_day;

		Scanner sc = new Scanner(System.in);
		System.out.println("만나이 계산기를 실행합니다.");
		System.out.println("태어난 년도를 입력하세요.");
		int year = sc.nextInt();
		System.out.println("태어난 월을 입력하세요.");
		int month = sc.nextInt();
		System.out.println("태어난 일(day)을 입력하세요.");
		int day = sc.nextInt();
		

		String date = year +"-"+ month +"-" + day;

		//2)배열만들고 3)윤년계산하여 예외처리하기
		int [] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
		if(year%400==0||(year%4==0&&year%100!=0))
			monthArray[1] = 29;

		// 1+) 잘못된 입력으로 인한 오류의 예외 처리하기 
		if((year > today_year)||
			(year ==today_year)&&(month > today_month)||
			(year == today_year)&&(month == today_month)&&(day > today_day)||
			(month > 12)|| (day > monthArray[month-1])||
			(year < 1900)||(month < 1)||(day <1)) {
			System.out.println("다시 입력하세요.");
			return;
		}
		
		
		//4)년,월,일별로 숫자 빼기
		int cal_year = today_year - year;
		int cal_month = today_month - month;
		int cal_day = today_day - day;
		
		//5)음수가 나오지 않게 하기
		if(cal_month < 0) {
			cal_year--;
			cal_month += 12;
		}
		if(cal_day < 0) {
			cal_month--;
			cal_day += monthArray[cal_month-1];
		}
		
		System.out.printf("만 %d년 %d개월 %d일입니다.\n",cal_year, cal_month, cal_day);	
		
		// + 출생일로부터 며칠이 지났는지 추가로 보기
		try{ 
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date TodayDate = format.parse(today_date);
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
