package com.yedam.variable;

import java.util.Scanner;//단축키 컨트롤+쉬프트+O

// 예금,출금,잔고 확인기능.

public class VarExe5 {
	public static void main(String[] agrs) {
		boolean run = true;
		int balance = 0;//예금액을 저장하는 변수.
		int inputMoney = 0;
		// 10만원 최대, 잔액이 > 0 조건
		
		Scanner scn = new Scanner(System.in);
		//while 반복분 true 이면 반복을 계속하고 false 이면 종료
		while(run) {
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			int menu = scn.nextInt();
			switch(menu) {
			case 1:
				System.out.print("금액을 입력>>");
				inputMoney = scn.nextInt();
				if(balance + inputMoney > 100000) {
					System.out.println("최대 금액은 10만원 입니다.");
				}else if(balance + inputMoney <= 100000) {
					balance = balance + inputMoney;					
				}
				break; // case 1 종료.
			case 2:
				System.out.print("출금 금액을 입력>>");
				inputMoney = scn.nextInt();
				if(balance - inputMoney < 0) {
					System.out.println("잔액이 부족합니다.");
				}else if (balance - inputMoney >= 0) {
					balance = balance -inputMoney;
				}
				break; // case 2 종료.
			case 3:
				System.out.print("현재의 잔고는: " + balance + " 입니다.");
				break; // case 3 종료.
			case 4:
				run = false;
			}
		}
		System.out.println("end of prog");
	}// end of main().
}
