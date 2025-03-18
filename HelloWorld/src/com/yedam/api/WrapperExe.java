package com.yedam.api;

import java.util.ArrayList;
import java.util.List;
/*
 * Wrapper (포장)클래스
 */
public class WrapperExe {
	public static void main(String[] args) {
		int[] intAry = {10, 20};
		List<Integer>list = new ArrayList<Integer>();//<>다음에 오는게 데이터 타입이다
		
		//추가할때는 add 를사용한다
		list.add(10);  //int -> Integer 박싱. Integer - > int 언박싱 
//		list.add(new Integer(20)); 원래는 이렇게 담아야하지만 위에처럼 박싱되어있다.
		
		
		//
		int num1= 10; // ==  두개의 값을 비교.
		Integer num2 = 20; // == 주소값을 비교 false.
		System.out.println(num1 == num2.intValue()); //비교할때에는 intValue를 사용 
		
	} // end of main
}
