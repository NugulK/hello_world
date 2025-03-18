package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		String str = "Hello, World";
		str =new String("Hello, World");
		byte[] bAry = str.getBytes(); // 읽은 바이트를 저장하기 위한 배열 생성
		for(int i=0; i<bAry.length; i++) {
			System.out.println(bAry[i]);
		}
		
		byte[] bstr = { 72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100 };
		String msg = new String(bstr, 7 ,5); // bstr, 7 ,5 하면 7번쨰부터 5글자해서 world 만출력된다.
		System.out.println(msg);
		char result = msg.charAt(0);
		System.out.println((int) result);
		
		//String:  "", char:''
		if(result == 'W') {
			// 비교구문.
		}
		//indexOf: 주어진위치를 찾는다 
		int idx = msg.indexOf("o");
		if (idx != -1) {
			//처리
		}
		
		String[] names = {"홍길동","홍길승","김민길","박홍길"};
		int cnt = 0;
		for(int i=0; i<names.length; i++) {
			if(names[i].indexOf("홍") != 0) { // indexOf사용하여 길을 포함한 사람의 수를 확인하기
				cnt++;
			}
		}
		System.out.println("\"홍\"을 성으로 갖는 이름의 갯수 : " +cnt);
		
		//substring:문자를 자르거나할때 사용
		System.out.println("Hello, World".substring(3,7)); //앞에값부터 뒤에값전까지 가져온다.
		
		//문자 추출 (charAt())
		String subject = "자바 프로그래밍";
		char charValue = subject.charAt(3);
		System.out.println(subject.charAt(3));
		
		//문자열 비교 (equals())
		String strVar1 = new String ("신민철");
		String strVar2 = "신민철";
		String strVar3 = "신민철";
		
		System.out.println(strVar1.equals(strVar2));
		System.out.println(strVar2.equals(strVar3));
		
		//바이트 배열로 변환(getBytes())
//		byte[] bytes = "문자열".getBytes();
//		byte[] bytes = "문자열".getBytes(Charset charset);
		
		
//		try {
//			byte[] byte1 = "문자열".getBytes("EUC-KR");
//			byte[] byte2 = "문자열".getBytes("UTF-8");
//		}
		} // end of main()
} //end of  Stringexe()
