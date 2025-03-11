package com.yedam.ref;

public class ArrayExe3Calendar {
	// 2025년 기준으로 월 정보 = > 1일의 위치를 반환해주는 메소드 생성
	public static int getFirstDay(int month) {
		switch(month) {
		case 1: 
			return 3;
		case 2:
			return 6;
		case 3:
			return 6;
		case 4:
			return 2;
			default :
				return 1;
		}
	}
		// 2025년 기준으로 월의 마지막날을 반환해주는 메소드 생성
	public static int getLastDate(int month) {
		int date = 31; // 1, 3, 5, 7, 8, 10 ,12월.
		switch(month) {
		case 2:
			date = 28;
			break;
		case 4: 
		case 6: 
		case 9: 
		case 11: 
			date = 30;
			break;
		}
		return date;
	}
	public static void main(String[] args) {
		String[] days = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		// 달력 3월 1 ~ 31 콘솔출력 (print vs. println) 
		//요일 출력
		for(String day : days) {
			System.out.print(" " + day);			
		}
		
		System.out.println(" "); // 줄바꿈
		int month = 1; 
		int space = getFirstDay(month); //3.1일이 토요일이라 금요일까지 공백주기위해서 사용 첫번째날의 위치값
		// getFirstDay(1) = 1월달의 첫번째날의 공백값을 입력한것
		int lastDate = getLastDate(month); // 마지막날 위치값.
		// 공백갯수만큼 빈칸.
		for(int i = 0; i <space; i++) {
			System.out.print("    ");
		}
		
		// 날짜출력. "1" - > 1: integer.parseInt()
		for(int i = 1 ; i <= lastDate; i++) {
			if(String.valueOf(i).length()==1) { // String.valueOf(i).length(문자 크기에 따라 차이를주기위해 사용)
				System.out.print("   " + i);
			}else if(String.valueOf(i).length()==2) {
				System.out.print("  " + i);
			}
			// 줄 바꿈.
			if((space+ i) % 7 == 0) {
				System.out.println();
			}
		}
		
	}
}
