
package basic0717_1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//<������ ���� ����� ����>
//1) ���� ��¥���ϱ�, �����¥ ���ϱ�
	// +�߸��� �Է��� ���� ó��
//2) ������ �ϼ��� �ٸ��� �׿� ���� �迭 �����
//3) �������Ͽ� ����ó���ϱ�
//4) ��, ��, �Ϻ��� ���� ����
//5) ������ ������ �ʰ� �ϰ�, �����


public class Age_Cal {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		//System.out.println(cal);
		
		//1) ���� ��¥�� �����¥ �Է�
		int today_year = cal.get(Calendar.YEAR);
		int today_month = cal.get(Calendar.MONTH) + 1;
		int today_day = cal.get(Calendar.DAY_OF_MONTH);
		String today_date = today_year +"-"+today_month +"-" + today_day;

		Scanner sc = new Scanner(System.in);
		System.out.println("������ ���⸦ �����մϴ�.");
		System.out.println("�¾ �⵵�� �Է��ϼ���.");
		int year = sc.nextInt();
		System.out.println("�¾ ���� �Է��ϼ���.");
		int month = sc.nextInt();
		System.out.println("�¾ ��(day)�� �Է��ϼ���.");
		int day = sc.nextInt();
		

		String date = year +"-"+ month +"-" + day;

		//2)�迭����� 3)�������Ͽ� ����ó���ϱ�
		int [] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
		if(year%400==0||(year%4==0&&year%100!=0))
			monthArray[1] = 29;

		// 1+) �߸��� �Է����� ���� ������ ���� ó���ϱ� 
		if((year > today_year)||
			(year ==today_year)&&(month > today_month)||
			(year == today_year)&&(month == today_month)&&(day > today_day)||
			(month > 12)|| (day > monthArray[month-1])||
			(year < 1900)||(month < 1)||(day <1)) {
			System.out.println("�ٽ� �Է��ϼ���.");
			return;
		}
		
		
		//4)��,��,�Ϻ��� ���� ����
		int cal_year = today_year - year;
		int cal_month = today_month - month;
		int cal_day = today_day - day;
		
		//5)������ ������ �ʰ� �ϱ�
		if(cal_month < 0) {
			cal_year--;
			cal_month += 12;
		}
		if(cal_day < 0) {
			cal_month--;
			cal_day += monthArray[cal_month-1];
		}
		
		System.out.printf("�� %d�� %d���� %d���Դϴ�.\n",cal_year, cal_month, cal_day);	
		
		// + ����Ϸκ��� ��ĥ�� �������� �߰��� ����
		try{ 
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date TodayDate = format.parse(today_date);
			Date FirstDate = format.parse(date);
			
			long calDate =TodayDate.getTime()-  FirstDate.getTime(); 
			long calDateDays = calDate / ( 24*60*60*1000);
			
			System.out.println("����Ϸκ��� �� "+calDateDays+"�� °�Դϴ�.");
		}
		catch(ParseException e)
		{
			// ���� ó��
		}
		
		
		
		
		
		
	}
}
