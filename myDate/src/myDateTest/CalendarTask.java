package myDateTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTask {
	public static void main(String[] args) {
		
		//본인의 생년월일 출력
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		//개발자들이 이미 싱글톤 패턴으로 구현해 놓음
		Calendar date = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
//		date.set(1993, 9, 28);//한번에 수정하는 방법
		//싱글톤 패턴. static이니까 클래스로 접근
		//하나씩 수정하는 방법
		date.set(Calendar.YEAR, 1993);
		date.set(Calendar.MONTH, 9);
		date.set(Calendar.DATE, 28);
		
		date2.set(Calendar.YEAR, 1991);
		date2.set(Calendar.MONTH, 1);
		date2.set(Calendar.DATE, 5);
		
		System.out.println("내 생일은 " + simpleDateFormat.format(date.getTime()) + "이다.");
		System.out.println("형 생일은 " + simpleDateFormat.format(date2.getTime()) + "이다.");
	}
}
