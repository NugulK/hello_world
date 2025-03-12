package com.yedam.variable;

import java.util.Scanner;

public class VarExe6 {
	public static void test() {
		//for(int i=1; i<= 5; i++)
			// 임의의 정수 1 ~ 50 임의의 값.
			System.out.println((int) (Math.random()*50) + 1); // 1 <= x < 51)
			//정수(int) -> 5개 저장.
			int[] scores = new int[5];
			int[] scorea = new int[500];
			
			for(int i=0; i< scores.length; i++) {
				//학생의 점수 (30~100 사이의 점수)
				scores[i] = (int)(Math.random()*71)+30;
				//홀수의 값만 출력.
				if(scores[i] % 2 == 1) {
					System.out.println(scores[i]);
				}
			}
			for(int i=0; i< scorea.length; i++) {

				scorea[i] = (int)(Math.random()*71)+30;
				// 100이나오면 출력
				if(scorea[i] == 100) {
					System.out.println(i + "번째 값: " + scorea[i]);
				}
			}
	} // end of test().
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); //Scanner 사용을위해 변수지정
		
		//학생의 이름, 점수를 한번에 담는다
		Member m1 = new Member(); // 인스턴스 생성.
//		m1.Name = "홍길동";
		// 값을 삽입하는곳에는 setScore, setName 
		m1.setName("홍길동");
		System.out.println(m1.getScore());
		Member m2 = new Member();
//		m2.Name = "최민수";
		m2.setName("최민수");	
		Member m3 = new Member();
//		m3.Name = "김병수";
		m3.setName("김병수");
		Member m4 = new Member();
//		m4.Name = "박인만";
		m4.setName("박인만");
		
		//배열.
		System.out.println("조회할 이름 입력>>"); //입력한 값을 배열에 담아야한다.
		Member[] members = {m1, m2, m3, m4};
		String search = scn.nextLine();
		int sum = 0;
 
		//70 ~ 100 사이의 임의값으로 점수지정.
//		for(int i = 0; i < members.length ; i++) {
//			members[i].score = (int) (Math.random() * 31 ) + 70;
//			System.out.println(members[i].name+ "," + members[i].score);
//			if(members[i].name.equals(search)) {
//				System.out.println(members[i].score);
//			}	
//		}
		
		for(int i = 0; i < members.length ; i++) {
//			members[i].scor = (int)(Math.random() * 31)+70;
			// 값을 삽입하는곳에는 setScore, setName 
			members[i].setScore((int) (Math.random() * 31 ) + 70);
			// 값을 불러오는 곳에는 getName, getScore
			System.out.println(members[i].getName()+ "," + members[i].getScore());
			if(members[i].getName().equals(search)) {
				sum =members[i].getScore();
			}	
		}
		System.out.println(sum);
		//조회이름을 입력 = > 점수출력.
//		for(int i = 0; i < members.length; i ++) {}
			
		// for 반복문 활용. 숫자를 비교  30 == 30, 문자열 비교할때는  members[i].name.equals(search)
		
		
		// 점수가 가장 높은 사람의 이름 출력
//		int max = members[0].score;  // 첫번째 사람의 값을임의로 담아둠
//		String name = members[0].name; //이름을 담기위한 변수 선언
//		for(int i = 0; i < members.length; i ++) {
//			// System.out.println(members[i].name+ "," + members[i].score); 확인용
//			if(max < members[i].score) { //max값 보다 i의 값이 더클때 max에다가 값을 넣어준다.
//				max = members[i].score; 
//				name = members[i].name;
//			}
//		}
//		System.out.println(" 최고점수는 " + name + max); //최고점수 출력
	} // end of main().
}
