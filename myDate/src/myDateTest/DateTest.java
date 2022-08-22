package myDateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		Date date = new Date();
		Date time = new Date();
		
		date.setYear(100);
		//월은 0~11. 0이 1
		date.setMonth(11);
		
		System.out.println(date);
		System.out.println(simpleDateFormat.format(date));
		
		try {
			//parse는 try catch
			time = simpleDateFormat.parse("2002년 12월 04일 09시 00분 00초");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(time);
		
	}
}
