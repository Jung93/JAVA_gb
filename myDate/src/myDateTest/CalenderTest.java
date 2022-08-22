package myDateTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalenderTest {
	public static void main(String[] args) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd aaa hh:mm:ss");
//		Calendar today = Calendar.getInstance();
//		System.out.println(today);
//		//getTime()
//		System.out.println(simpleDateFormat.format(today.getTime()));
	
		Calendar date = Calendar.getInstance();
//		date.set(2000, 11, 4);
//		date.set(Calendar.YEAR, 2000);
//		date.set(Calendar.MONTH, 11);
//		System.out.println(simpleDateFormat.format(date.getTime()));
		System.out.println(date.get(Calendar.YEAR));
		System.out.println(date.get(Calendar.MONTH)+1);
		
	}
}
