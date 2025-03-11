package com.yedam.ref;

import com.yedam.variable.Member;

public class ArrayExe2 {
	public static void main(String[] args) {
		String[] strAry = {"Hello","World","20","23.4"} ;  //문자열만 담을수 있는 배열 생성 /선언과 동시에 값을 담고 싶다면{}를 사용해서 담아준다.
		//확장 for.문
		for(String str : strAry) {
//			System.out.println(str);
		}
		//크기 지정.
		strAry = new String[10]; // 문자열을 담을수 있는 공간 10개만들었다. 초기값은 null {null,null,...,null};
		strAry[0] = new String("Nice");
		for(String str : strAry) {
//			System.out.println(str);
		}
		// Member 클래스. = 데이터 타입에대한 설명
		Member[] memAry = new Member[10];  // {null, null, ..., null};
		memAry[0] = new Member(); // new 인스턴스 생성 (객체생성) 
		memAry[0].setMember("홍길동", 80); //홍길동의 값 80 > 90
		memAry[0].setScore(150);
		memAry[0].showInfo(); // 값을 보여준다.
		
		memAry[1] = new Member(); // 두번째위치에는 값을 할당하는 작업을 제외했을때 에러가 발생한다 
		memAry[1].setMember("김혁규", 90); //김혁규의 값 90 > 95
		memAry[1].setScore(-95);
		memAry[1].showInfo(); // 값을 보여준다.
		
		memAry[2] = new Member("최민혁", 77);
		memAry[2].showInfo();
		
		//반복문을 이용해서 출력
//		for (int i = 0; i < memAry.length; i++) {
//			if (memAry[i] != null) {
//				memAry[i].showInfo(); // 3번째 부터는 null값이라 에러발생 그래서if 문을써서 널값이 아닐경우에만 보여주세요 라고 주문
//			}
//		}
		
	} // end of main()
}
