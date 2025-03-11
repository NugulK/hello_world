package com.yedam.variable;

// 관례 : 클래스의 이름은 대문자로 시작.
public class VarExe1 {
	public static void main(String[] args) {
		// 연산은 두 변수의 유형(data type)이 항상 동일.
		int number1 = 70;
		int number2 = 80;
		number1 = 71;
        //int number1 = 72 동일한 이름의 변수를 두번 선언할수는 없다.
		//연산을 할때는 int + int 
		//더 해진값도 int 에 담음 
		int sum = number1 + number2 ;
		
		System.out.println("두 점수의 합은 " + sum + "입니다.");
		
		double avg = (double)sum / 2.0 ;
		//두타입을 같게 해야해서 sum에 double로 감싸주고 2.0으로 지정해준다.
		//double avg = sum / 2 ;
		// 둘다 정수라 75.0 이라고 나온다.
		//소숫점까지 가지고있는 타입 : double
		//int avg = sum / 2 ;
		//정수 타입이라 소숫점이 나오지않는다.
		
		System.out.println("두 점수의 평균은 " + avg + "입니다.");
	}
}
