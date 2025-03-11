package com.yedam.variable;

import java.util.Scanner;

public class VarExe4 {
	public static void main(String[] args) {
		int[] scores = new int[3]; // {0 ,0 ,0} 정수값을 담을수있는 배열이 선언됫다
		Scanner scn = new Scanner(System.in);
		int sum = 0;
		double avg = 0.0;
		for(int i=0; i<scores.length; i++) {
			// 점수를 입력하세요.
			System.out.print("점수를 입력 하세요.");
			// 값 입력.
			scores[i] = scn.nextInt();
			// 입력값의 합을 콘솔에 출력.
			System.out.println("입력한 값 " + scores[i]);
			sum = sum + scores[i];
		}
		avg = sum * 1.0 / scores.length; 
		// "합은 240입니다".
		System.out.println("합은 " + sum + "입니다");
		System.out.println("평균 " + avg + "입니다");
	}// end of main.
}
