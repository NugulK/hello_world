package com.yedam.bookApp;
/*
 *  실행클래스(main 메소드)
 */
public class BookApp {
		public static void 	main(String[] args) {
			// 싱글톤 방식 
			//4.번 정적필드에서 참조하는 자신의 객체 리턴
			BookMain mainApp1 = BookMain.getInstance();
//			mainApp.main(args);
			
			BookMain mainApp2 =  BookMain.getInstance();
			
			mainApp1.add(); // 1번에 등록.
			mainApp1.list(); //
			
			mainApp2.list(); // 2번 목록.
			
		}
}
