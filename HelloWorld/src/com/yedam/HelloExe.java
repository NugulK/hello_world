package com.yedam;

public class HelloExe {
	// 기능(함수) => main 메소드.
	public static void main(String[] args) {
		System.out.println("Hello,World");
		
		String name;
		name = "권민준";
		// 변수를 선언할때는 타입을 적어줘야한다.
		
		System.out.println("이름은" + name);
		
		int score = 100;
		//int = 정수
		System.out.println("점수는 " + score + "점 입니다.");
		System.out.println("수정된 부분");
		//문자열 + 정수 + 문자열 = 문자열 + 문자열 + 문자열 로 변경하고 보여준다.
		//더하기 연산자는 타입이 같아야 한다.
	}
}
