package com.yedam.classes;

import java.util.Arrays;

public class MethodExe3 {
	//구구단출력.
	String gugudan(int num , int toNum) {
		String str = "";
		for(int i = num; i <=toNum ; i ++) {
			for(int j = 1; j <= 9 ; j ++) {
			str = str + i + " * " + j + " = " + (i * j ) + "\n" ;	
			}
			str = str + "\n" ;
		} 
		return str;
	} // end of gugudan. 
	//void = 일때는 sysoutprint 
	void printStar(int cnt, String str) {
		for(int i = 1; i <=cnt; i++) {
			for(int j = 0; j < i; j++ ) {
				System.out.print(str);
			}
			System.out.println();
		}
	} // end of printStar()
	
	void printCard() {
		//배열선언
		int [] intAry = new int[16];
		// 1 ~ 16까지의 임의수 할당.
		for(int i = 0; i < intAry.length; i++) {
			intAry[i] = (int) (Math.random() * 16) +1;
			
		}
		
		//출력
		for (int i = 0; i< intAry.length; i++) {
			System.out.printf("%3d",intAry[i]);
			if(i % 4 == 3 ) {
				System.out.println();
			}
		}
	}
}
