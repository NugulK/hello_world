package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExe {
	public static void main(String[] args) {
		Date today = new Date();
		System.out.println(today.toString());
		
		//출력 포맷을 지정해주는 클래스
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatStr = sdf.format(today); 
		System.out.println(formatStr);
		
		//문자열을 Date타입으로 바꿔주는 메소드 
		try {
			Date tday = sdf.parse("2000-01-01 10:00:00");
			System.out.println(tday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	} // end of main()
}
