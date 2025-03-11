package com.yedam.ref;

public class ArrayExe1 {
	public static void main(String[] args) {
		int[] intAry = {10,20,30}; //정수를 담을수 있는 배열
		for (int i = 0 ; i < 3 ; i++) {
			System.out.println(intAry[i]); //배열의 위치의 값을 가르킨다.
		}
		
		intAry = new int[] { 40, 50, 60 }; //다시 값을 주고 싶을때는 이렇게 해야한다. new:객체의 주소값을 반환해준다.
		
		// 배열의 크기로 지정
		intAry = new int[10]; //{0, 0, ...,0} 이런값들이 총 10개가 있는 배열이 생성
		intAry[3] = 30; // intAry안에 있는 4번째에 값을 30으로 변경 , 배열은 0부터 시작하기때문에 [3] = 4번째위치이다. 
		intAry[9] = 90; // 10번째에 잇는 값을 90으로 변경
		
		// intAry[10] = 100; 범위에 넘어가는 값을 입력하면 예외 발생(오류 발생).
		intAry[1] = 100;
		intAry[0] = (int)(Math.random() *100) + 1;
		for(int i = 0; i < intAry.length; i++) {      // 나머지 값에 반복문을써서 랜덤값을 부여 했다.
			if(intAry[i] == 0) {
				intAry[i] = (int)(Math.random() *100) + 1;
			}
		}
		// 생성되어있는 홀수 값의 합 구하기.
		// 출력할때 "홀수값의 합은 000입니
		for (int i = 0; i < intAry.length; i++) {
			System.out.println(i + "번째 값은" + intAry[i]);
		}
		int sum = 0 ;
		for(int i = 0; i <intAry.length; i++) {
			if(intAry[i] % 2 == 1) {
				sum = sum + intAry[i];
			}
		}
		System.out.println("홀수 값의 합은 :" + sum);
		
		
	} // end of main()
}
