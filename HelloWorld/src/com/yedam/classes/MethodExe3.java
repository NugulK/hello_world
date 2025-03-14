package com.yedam.classes;

import java.util.Arrays;

public class MethodExe3 {
	// 기능을 실행만 하는 
	
	// 정적(static) 멤버
	//클래스에 고정된 멤버로서 객체 생성하지 않고 사용할 수 있는 필드와 메소드
	// static이라고 선언하면 바로쓸수 잇는 필드와 메소드 이다.
	// 호출할때는 클래스이름.필드; | 클래스이름.메소드(매개값,...);
	
	//구구단출력.
	static String gugudan(int num , int toNum) {
		String str = "";
		for(int i = num; i <=toNum ; i ++) {
			for(int j = 1; j <= 9 ; j ++) {
			str = str + i + " * " + j + " = " + (i * j ) + "\n" ;	
			}
			str = str + "\n" ;
		} 
		return str;
	} // end of gugudan. 
	//void = 일때는 sysoutprint 로 하면안된고 .
	static void printStar(int cnt, String str) {
		for(int i = 1; i <= cnt; i++) {
			for(int j = 1; j <= cnt ; j++ ) {
				if(j <= i) {
					System.out.print(str); //기호.					
				}
			}
			System.out.println(); // 줄바꿈.
		}
	} // end of printStar()
	
	
	// 카드번호 보여주기. 중복을 제거.
//	void printCard() {
//		//배열선언
//		int [] intAry = new int[16];
//		// 1 ~ 16까지의 임의수 할당.
//		for(int i = 0; i < intAry.length; i++) {
//			int temp =  (int)(Math.random()* 16)+1;
//			//이전에 생성된 값인지 체크.
//			boolean dup = false;
//			for(int j = 0; j < i; j++) {
//				if(intAry[i] == temp) {
//					dup = true;
//				}else if(){
//	
//				}
//			}
//    	}
//		//출력
//		for (int i = 0; i< intAry.length; i++) {
//			System.out.printf("%3d",intAry[i]);
//			if(i % 4 == 3 ) {
//				System.out.println();
//			}
//		}
//	}
	
	// 인스턴스 멤버와 정적 멤벗 선택기준
	//객체 마다 다를수있는 필드값 -> 인스턴스 필드로선언
	// 그렇지 않고 객체마다 다를 필요가 없는 필드값 -> 정적 필드로 선언.
}
