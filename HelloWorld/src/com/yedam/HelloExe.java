package com.yedam;

import com.yedam.classes.MethodMain;

public class HelloExe {
	// 기능(함수) => main 메소드.
	private String pName;
	private String pTell;
	private int pAge;
	
	HelloExe() {}
	HelloExe(String name , String tell , int age){
		this.pName = name;
		this.pTell = tell;
		this.pAge = age;
	}
	
		
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpTell() {
		return pTell;
	}
	public void setpTell(String pTell) {
		this.pTell = pTell;
	}
	public int getpAge() {
		return pAge;
	}
	public void setpAge(int pAge) {
		this.pAge = pAge;
	}
	public static void main(String[] args) {
		// 1. 32000 변수선언과 할당.
		int num = 32000;
		
		// 2. 정수를 여러개를 담을수있는 지정 2, 34, 32, 88, 23
		int[] nums = {2, 34, 32, 88, 23};
		
		//3. 문자 : 32
		String su = "32";
		
		//4. 정수변수에 저장.
		int su2 = Integer.parseInt(su);
		
		// 5.문자를 여러개 담기 hello Nice Good
		String[] mun = {"Hello","Nice","Good"};
		
		// 6. 정수 5개를 저장할수있는 배열선언.
		// Marh.random() - > 60 ~ 100사이
		int[] scores = new int[5];
		for (int i = 0; i < scores.length; i++) {
			scores[i] = (int)(Math.random() *41) +60;
			System.out.println(scores[i]);
		}
		// 7. 이름, 연락처, 나이 데이터타입 선언.
		String name = "홍길동";
		String tell = "010-1234-1234";
		int age = 20;
		// 홍길동, 010-1234-1234 , 20
		// 8. [3]
		// 홍길동, 010-1234-1234 ,20
		// 김민식, 010-2222-2222 ,22
		// 최문식, 010-3333-3333 ,23
		
		HelloExe[] infoAry = new HelloExe[3];
		infoAry[0]= new HelloExe(name,tell,age);
		infoAry[1]= new HelloExe("김민식", "010-2222-2222" ,22);
		infoAry[2]= new HelloExe("최문식", "010-3333-3333" ,23);
		
		
		
		//9. 나이가 제일 많은 사람의 이름을 출력
		int ages = 0;
		String names = "";
		
		for(int i = 0;  i < infoAry.length ; i++) {
			if( infoAry[i].getpAge() > ages ) {
				ages = infoAry[i].getpAge();
				names = infoAry[i].getpName();
			}				
		}
		System.out.println(names);		
//		MethodMain mm = new MethodMain();
//		mm.main(args); //패키지가 다르더라도 접근이 가능한것은 public 
		
//		mm.officeApp(); // 패키지가 다르면 접근불가 == default
		
//		
//		System.out.println("Hello,World");
//		
//		String name;
//		name = "권민준";
//		// 변수를 선언할때는 타입을 적어줘야한다.
//		
//		System.out.println("이름은" + name);
//		
//		int score = 100;
//		//int = 정수
//		System.out.println("점수는 " + score + "점 입니다.");
//		System.out.println("수정된 부분");
		//문자열 + 정수 + 문자열 = 문자열 + 문자열 + 문자열 로 변경하고 보여준다.
		//더하기 연산자는 타입이 같아야 한다.
	}
}
