package com.yedam.variable;

import java.util.Scanner;

// 추가, 수정, 삭제, 목록 출력.

public class VarExe7 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run  = true; // 숫자를 눌러 불러오는 기능을 사용하기위해서 boolean 사용
		//Member 값을 저장 할수 있도록 배열 선언.
		Member[] storage = new Member[50]; //초기값이 {null, null, ... null}
		storage[0] = new Member ("홍길동",83); // 예제등록
		storage[1] = new Member ("김민혁",86); // 예제등록
		storage[2] = new Member ("한수아",90); // 예제등록
		//1번을 누르면 스토리지에 저장되게 한다.
//		Member member = new Member(); // 인스턴스 생성. new = Member에 메모리값을 반환
		
		while(run) {
			System.out.println("1.등록 2.수정 3.삭제 4.목록 5.평균 6.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine()); //1 엔터.둘다 처리해주기위해 NextLine을 사용한다 그러면 타입이 달라서 오류가 발생 바꿔주기위해Integer.parseInt로 감싸준다.
			Member member = new Member();
			String name = "";
			int score = 0;
			
			switch(menu) {
			case 1: //등록. 
				System.out.print("이름을 입력>> ");
				name = scn.nextLine(); //이름을 입력받고
				System.out.print("점수 입력>> ");
				score  = Integer.parseInt(scn.nextLine()); //엔터까지 처리해주는 Integer.parseInt(scn.nextLine()); 를 사용. 점수를 입력받음
				//member.name = name; 
				//member.score = score;
				member.setMember(name, score);
				// 빈공간에 값을 하나 할당.
				for (int i = 0; i < storage.length; i ++) {
					if(storage[i] == null) { // 스토리지가 비여잇는곳을 찾기위해
						storage[i] = member; //비어있으면 멤버값을 넣는다.
						System.out.println("정상적으로 등록되었습니다."); //등록되었을때 출력
						break; //for 반복문 종료.
					}
				}
				break; // case 1의 종료.
			case 2: //수정.
				System.out.println("수정할 이름을 입력>>");
				name = scn.nextLine();
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null && storage[i].getName().equals(name)){
						System.out.println("수정할 값을 입력해주세요.");
						score = Integer.parseInt(scn.nextLine());
//						member.name = name; 
//						member.score = score;
						member.setMember(name, score);
						storage[i] = member;
//						storage[i].name = name;
//						storage[i].score = score;
						System.out.println("수정되었습니다.");						
					}else if (storage[i].getName().equals(name) != true) {
						System.out.println("수정하려는 이름이 목록에 존재하지 않습니다.");
						break;
					}
				}
				break; // case 2의 종료.
			case 3: //삭제. 이름입력 조회 후  = > null 대입
				System.out.println("삭제할 이름을 입력>>");
				name = scn.nextLine(); 
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null && storage[i].getName().equals(name)) { // && storage[i].name.equals(name) <- && 그리고 입력한 이름의 값이 똑같을 경우 
						storage[i] = null; // 널값을 넣어주면 삭제가된다.
						System.out.println("삭제되었습니다.");
						break;
					}else if (storage[i] != null && storage[i].getName().equals(name) != true) {
						System.out.println("삭제하려는 이름이 목록에존재하지 않습니다.");
						break;
					}
				}
				break; //case 3의 종료.
			case 4: // 목록 출력.
				System.out.println("이름 점수");
				System.out.println("==========");
				for(int i = 0; i < storage.length ; i++) {
					if(storage[i] != null) {  // null 값을 굳이 볼필요가없기때문에 if문을 사용해서 null값이 아닌것만 본다.
						System.out.println(storage[i].getName() + " " + storage[i].getScore());
					}
				}
				break; // case 4의 종료.
			case 5: //평균 구하기
				int sumScore = 0;
				int numM = 0;
				double avgScore = 0;
				for(int i=0; i < storage.length; i++) {
					if(storage[i] != null) {
						sumScore = sumScore+storage[i].getScore();
						numM++;
					}
				}
				avgScore = (sumScore * 1.0) / numM;
				System.out.println("평균은 : "+avgScore);
				break;
			case 6: 
				run = false;
			}
		}
		System.out.println("end of prog.");
	} // end of main().
}
