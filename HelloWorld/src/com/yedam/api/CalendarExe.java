package com.yedam.api;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) { // 2025-03-18
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, 2024);//2024. 객체를 생성하여 연도를 바꿀때 사용한다.
//		cal.set(Calendar.MONTH, 1); // 2월.
//		cal.set(Calendar.DATE, 10); // 10일.
//		cal.set(2023,2,5); //2023년 3월 5일.
//		
//		System.out.println(cal.get(Calendar.YEAR));
//		System.out.println(cal.get(Calendar.MONTH)); // 1월이 0이라 3월이 2이다.
//		System.out.println(cal.get(Calendar.DATE));
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); // 요일. 일요일부터시작해서 3이 화요일
//		System.out.println(cal.getActualMaximum(Calendar.DATE)); // 월의 마지막날 출력
		
		//년, 월 입력 => 1일의 요일 반환. 말일을 반환.
        getDay(2025,7); // 7월달의 1일의 요일
        System.out.println(getDay(2025,7));
		getLastDate(2025, 7); //7월달의 마지막날
		System.out.println(getLastDate(2025, 7));
		
	}
	
	static String getDay (int year, int month) {
		Calendar today = Calendar.getInstance();
		today.set(year, month - 1, 1);
		int day = today.get(Calendar.DAY_OF_WEEK);
		switch(day) {
		case 0: 
			return "일요일";
		case 1:
			return "월요일";
		case 2:
			return "화요일";
		case 3:
			return "수요일";
		case 4:
			return "목요일";
		case 5:
			return "금요일";
		case 6:
			return "토요일";
		default :
			return "요일을 입력해주세요";
		}
	}
	
	static int getLastDate(int year, int month) {
		Calendar day = Calendar.getInstance();
		day.set(year, month -1 , 1);
		int lastDay = day.getActualMaximum(Calendar.DATE);
		return lastDay;
	}
}
