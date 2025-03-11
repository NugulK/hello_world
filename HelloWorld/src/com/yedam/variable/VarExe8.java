package com.yedam.variable;

public class VarExe8 {
	public static void main(String[] args) {
		int n1 = 10;
		byte b1 = 120;
		byte result = (byte)(b1 + 130) ; //byte: 값의 범위가 -128 ~ 127  byte 타입은 1byte b1+30하면 둘다  int 타입이여서 int = 4byte 라 오류발생 
		// 해결하기위해(byte)()묶어주면 형변환(casting)해야 결과확인가능하다.
		// 130을 더햇을때 127보다 크기때문에 크기의 범위를 벗어나면 젤작은값의 범위로 변화된다.
		System.out.println("더한 결과: " + result); //결과 확인
		//  byte - > int (자동형변환)
		n1 = b1;
		System.out.println(n1);
		// int -> byte (형변환을 해주면 범위가 넘으면 손실이 발생)
		n1 = 200;
		b1 = (byte)n1; 
		System.out.println(b1);
		
		//반복문으로 확인해보기
		for(int i=1; i<15; i++) {
			System.out.println(b1++);
		}
	} // end of main()
}
